/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis;

import com.geradorcodigo.builders.xml.mybatis.exception.SelectGenericsXmlException;
import com.geradorcodigo.builders.xml.mybatis.util.XmlMybatisUtil;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.util.Util;
import com.geradorxml.mybatis.Include;
import com.geradorxml.mybatis.Select;
import java.util.List;
import org.hibernate.jdbc.util.BasicFormatterImpl;
import org.hibernate.jdbc.util.Formatter;

/**
 *
 * @author T01BRQ0067
 */
public class SelectGenericsXmlMybatis {

    private String nomeTabela;
    private List<Coluna> colunas;
    private String ID_COLUNA = "[COLUNAS]";
    private String ID_WHERE = "[WHERE]";
    private String ID_TABELA = "[TABELA]";
    private final String selectPaginado = "select * from (select ROWNUM as rownumber,SelectPrincipal.* from (Select <include refid=\""+ID_COLUNA+"\"/> from "+ID_TABELA+" <include refid=\""+ID_WHERE+"\"/>) SelectPrincipal)where rownumber between #{skipResults} and #{maxResults}";
    private final String selectPaginadoCount = "select count(1) from "+ID_TABELA+" <include refid=\""+ID_WHERE+"\"/>";
    private final String select = "Select <include refid=\""+ID_COLUNA+"\"/> from "+ID_TABELA+" <include refid=\""+ID_WHERE+"\"/>";
    private final BasicFormatterImpl formatterImpl = new BasicFormatterImpl(); 
   
    public SelectGenericsXmlMybatis(String nomeTabela, List<Coluna> colunas) {
        this.nomeTabela = nomeTabela;
        this.colunas = colunas;
    }

    public Select getSelectFindbyKey(String nomeColunaId,String nomeColunaDescricao, String resultMap, String parameterType) throws GeradorException {
        Select s = new Select();
        s.setId("findByKey"+Util.converteNomeTabelaToClasse(nomeTabela));
        s.setParameterType(parameterType);
        s.setResultMap(resultMap);
        Coluna colunaId = validaNomeColuna(nomeColunaId);
        if(!colunaId.getPrimaryKey()){
            throw new SelectGenericsXmlException("A coluna informada não eh uma chave primaria.");
        }
        validaNomeColuna(nomeColunaDescricao);
        String sql = "select ".concat(nomeColunaId).concat(", ").concat(nomeColunaDescricao).concat(" from ").concat(nomeTabela).concat(" where ").concat(XmlMybatisUtil.buildCondicaoSql(XmlMybatisUtil.idColunasSql(colunas)));
        sql = formatterImpl.format(sql);
        s.getValue().add(Util.tabLineString(sql, "\t"));
        return s;
    }
    public Select getSelectAutoComplete(String nomeColunaId,String nomeColunaDescricao, String resultMap, String parameterType) throws GeradorException {
        Select s = new Select();
        s.setId("autoComplete"+Util.converteNomeTabelaToClasse(nomeTabela));
        s.setParameterType(parameterType);
        s.setResultMap(resultMap);
        validaNomeColuna(nomeColunaId);
        Coluna colunaDescricao = validaNomeColuna(nomeColunaDescricao);
        Coluna colunaId = validaNomeColuna(nomeColunaId);
        List<Coluna> ids = XmlMybatisUtil.idColunasSql(colunas);
        ids.remove(colunaId);
        String condicaoId = XmlMybatisUtil.buildCondicaoSql(ids);
        String condicao = "UPPER("+colunaDescricao.getNome()+") LIKE '%'||UPPER(#{"+XmlMybatisUtil.getProperty(colunaDescricao)+"})||'%'"+(!condicaoId.equals("")?" and "+condicaoId:"");
        String sql ="select ".concat(nomeColunaId).concat(", ").concat(nomeColunaDescricao).concat(" from ").concat(nomeTabela).concat(" where ").concat(condicao).concat(" and rownum <![CDATA[<=]]> 50");
        sql = formatterImpl.format(sql);
        s.getValue().add(Util.tabLineString(sql, "\t"));
        return s;
    }
    private Coluna validaNomeColuna(String nome) throws SelectGenericsXmlException{
        for (Coluna coluna : colunas) {
            if(coluna.getNome().equalsIgnoreCase(nome)){
                return coluna;
            }
        }
        throw new SelectGenericsXmlException("A coluna ["+nome+"] informada, não foi encontrada.");
    }
    public Select getSelectPaginatedCount(Include includeWhere, String resultMap, String parameterType) {
        Select s = new Select();
        s.setId("selectPaginatedList"+Util.converteNomeTabelaToClasse(nomeTabela)+"Count");
        s.setParameterType("java.util.Map");
        s.setResultType("java.lang.Integer");
        String sql = selectPaginadoCount.replace(ID_WHERE, includeWhere.getRefid()).replace(ID_TABELA, nomeTabela);
        sql = formatterImpl.format(sql);
        s.getValue().add(Util.tabLineString(sql, "\t"));
        //Criando o sql do where
//        s.getValue().add(includeWhere);
        return s;
    }
    public Select getSelectPaginated(Include includeColunas, Include includeWhere, String resultMap, String parameterType) {
        Select s = new Select();
        s.setId("selectPaginatedList"+Util.converteNomeTabelaToClasse(nomeTabela));
        s.setParameterType("java.util.Map");
        s.setResultMap(resultMap);
        String sql = selectPaginado.replace(ID_COLUNA, includeColunas.getRefid()).replace(ID_WHERE, includeWhere.getRefid()).replace(ID_TABELA, nomeTabela);
        sql = formatterImpl.format(sql);
        s.getValue().add(Util.tabLineString(sql, "\t"));
        //Criando o sql das colunas
//        s.getValue().add(includeColunas);
//        s.getValue().add("\n\t\t\t\t\tfrom uniurg_veiculos");
//        //Criando o sql do where
//        s.getValue().add(includeWhere);
//        s.getValue().add(fimSelectPaginado);
        return s;
    }
    public Select getSelect(Include includeColunas, Include includeWhere, String resultMap, String parameterType) {
        Select s = new Select();
        s.setId("pesquisa"+Util.converteNomeTabelaToClasse(nomeTabela));
        s.setParameterType(parameterType);
        s.setResultMap(resultMap);
        String sql = select.replace(ID_COLUNA, includeColunas.getRefid()).replace(ID_WHERE, includeWhere.getRefid()).replace(ID_TABELA, nomeTabela);
        sql = formatterImpl.format(sql);
        s.getValue().add(Util.tabLineString(sql, "\t"));
        //Criando o sql das colunas
//        s.getValue().add(includeColunas);
//        s.getValue().add("\n\tfrom " + nomeTabela + "\n");
//        //Criando o sql do where
//        s.getValue().add(includeWhere);
        return s;
    }
}
