/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.builders.xml.mybatis.util.XmlMybatisUtil;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorxml.mybatis.If;
import com.geradorxml.mybatis.Sql;
import com.geradorxml.mybatis.Where;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class SqlXmlMybatis {
    private List<Coluna> colunas;

    public SqlXmlMybatis(List<Coluna> colunas) {
        this.colunas=colunas;
    }

    
    public Sql getSqlColumn(String id){
        Sql s = new Sql();
        s.setId(id);
        String resultado = XmlMybatisUtil.buildColunasSql(colunas,true);
        s.getValue().add("\n"+resultado.toString());
        return s;
    }
    
    public Sql getWhereSqlWithIf(String id,String concat) throws GeradorException {
        Sql sql = new Sql();
        sql.setId(id);
        Where e = new Where();
        montaCondicao(e.getValue(),concat);
        sql.getValue().add(e);
        return sql;
    }

    private void montaCondicao(List<Object> ifs,String concat) throws GeradorException {
        If i = null;
        for (Coluna coluna : colunas) {
            i = (new IfXmlMybatis().buildIf(coluna,concat));
            i.setvalue("AND ".concat(coluna.getNome().toUpperCase()).concat("=#{").concat(concat).concat(XmlMybatisUtil.getProperty(coluna)).concat("}"));
            ifs.add(i);
        }
    }
}
