/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.dao.banco;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.dao.Conexao;
import com.geradorcodigo.dao.ConexaoException;
import com.geradorcodigo.domain.banco.Check;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.banco.Forengkey;
import com.geradorcodigo.domain.banco.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T01BRQ0067
 */
public class ColunaDaoImpl implements ColunaDao{

    public ColunaDaoImpl() {
    }

    public List<Coluna> select(Tabela tabela) throws GeradorException {
        Connection c = null;
        try {
            c = new Conexao().getConnection();
            PreparedStatement ps = c.prepareStatement("select t.owner owner, t.table_name nome_tabela, "
                                                            +"c.COLUMN_NAME nome_coluna, "
                                                            +"c.DATA_TYPE tipo_coluna, "
                                                            +"decode(data_type,'NUMBER',C.DATA_PRECISION,C.DATA_LENGTH) TAMANHO, "
                                                            +"acc.comments comentario, "
                                                            +"c.NULLABLE NULLABLE, "
                                                            +"c1.CONSTRAINT_NAME nome_constrait, "
                                                            +"c1.SEARCH_CONDITION check_coluna, "
                                                            +"c2.r_table_name r_table_name, " 
                                                            +"c2.constraint_name r_pk, " 
                                                            +"c2.DEST_COLUMN, "    
                                                            +" (SELECT COUNT(1)"
                                                               +" FROM all_constraints cons, all_cons_columns cols"
                                                              +" WHERE cols.table_name = C.TABLE_NAME"
                                                               +"  AND cons.constraint_type = 'P'"
                                                                +" AND COLS.COLUMN_NAME=C.COLUMN_NAME"
                                                                +" AND cons.constraint_name = cols.constraint_name"
                                                                +" AND cons.owner = cols.owner )  PK "
                                                     +" from all_tables t, "
                                                          +"all_tab_cols c, "
                                                          +"all_col_comments acc, "
                                                            +"(select ac.*, cc.SEARCH_CONDITION "
                                                            +"from All_Cons_Columns ac,all_constraints cc "
                                                            +"where ac.TABLE_NAME  = cc.TABLE_NAME "
                                                            +"and ac.CONSTRAINT_NAME=cc.CONSTRAINT_NAME "
                                                            +"and ac.OWNER=cc.OWNER "
                                                            +"and cc.GENERATED = 'USER NAME' "
                                                            +"and cc.CONSTRAINT_TYPE='C') c1, "
                                                            +"(SELECT a.*,  "
                                                                    +" c.r_owner, "
                                                                    +" c_pk.table_name r_table_name, "
                                                                    +" c_dest.COLUMN_NAME as DEST_COLUMN, "    
                                                                    +" c_pk.constraint_name r_pk "
                                                               +" FROM all_cons_columns a,"
                                                                    +" all_constraints c,"
                                                                    +" ALL_CONS_COLUMNS c_dest,"     
                                                                    +" all_constraints c_pk"
                                                              +" WHERE c.constraint_type = 'R'"
                                                              +"  and c.CONSTRAINT_NAME = a.CONSTRAINT_NAME"
                                                              +"  AND c.R_CONSTRAINT_NAME = c_dest.CONSTRAINT_NAME"
                                                                +" and a.owner = c.owner"
                                                                +" AND a.constraint_name = c.constraint_name"
                                                                +" and c.r_owner = c_pk.owner"
                                                                +" AND c.r_constraint_name = c_pk.constraint_name) C2 "
                                                    +"where upper(t.TABLE_NAME) = upper(?) "
                                                    +"and upper(t.owner) = upper(?) "
                                                    +"and T.TABLE_NAME = c.TABLE_NAME "
                                                    +"and T.owner = c.owner "
                                                    +"and c.OWNER=c1.OWNER(+) "
                                                    +"and c.TABLE_NAME = c1.TABLE_NAME(+) "
                                                    +"and c.COLUMN_NAME =c1.COLUMN_NAME(+) "
                                                    +"and c.OWNER=acc.OWNER(+) "
                                                    +"and c.TABLE_NAME = acc.TABLE_NAME(+) "
                                                    +"and c.COLUMN_NAME =acc.COLUMN_NAME(+) "
                                                    +"and c.OWNER=c2.OWNER(+) "
                                                    +"AND c.table_name = c2.table_name(+) "
                                                    +"and c.COLUMN_NAME =c2.COLUMN_NAME(+)");
            ps.setString(1, tabela.getNome());
            ps.setString(2, tabela.getOwner());
            ResultSet rs = ps.executeQuery();
            List<Coluna> list = new ArrayList<Coluna>();
            String ck = "";
            String pk = "";
            while (rs.next()) {
                ck =rs.getString("check_coluna");
                pk =rs.getString("PK");
                Coluna col = new Coluna("1".equals(pk), tabela,
                                        rs.getString("nome_coluna"), 
                                        rs.getString("tipo_coluna"), 
                                        rs.getInt("TAMANHO"), 
                                        new Boolean("Y".equalsIgnoreCase(rs.getString("NULLABLE"))), 
                                        rs.getString("comentario"), 
                                        new Check(ck, 
                                                  rs.getString("nome_constrait"), 
                                                  null),
                                        new Forengkey(rs.getString("r_pk"), 
                                                      rs.getString("r_table_name"),
                                                      rs.getString("DEST_COLUMN"))          
                                        );
                
                list.add(col);
            }
            return list;
        } catch (SQLException ex) {
            throw new ColunaException("Erro ao excutar a consulta das colunas.", ex.getMessage());
        } catch (ConexaoException ex) {
            throw ex;
        }finally{
            desconectar(c);
        }
    }

    private void desconectar(Connection c) throws ColunaException{
        try {
                if(c != null && !c.isClosed()){
                    c.close();
                }
            } catch (SQLException ex) {
                throw new ColunaException("Erro ao fechar a conexão.",ex.getMessage());
            }
    }
    
     public static void main(String[] args) {
        try {
            ColunaDaoImpl td = new ColunaDaoImpl();
            Tabela t = new Tabela();
            t.setNome("unimeds");
            t.setOwner("sabius");
            List<Coluna> l = td.select(t);
            for (Coluna co : l) {
                System.out.println(co);
            }
        } catch (GeradorException ex) {
            System.out.println(ex.getDetalhe());
            Logger.getLogger(ColunaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
