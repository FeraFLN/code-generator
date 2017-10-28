/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis;

import com.geradorcodigo.builders.xml.mybatis.util.XmlMybatisUtil;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.util.Util;
import com.geradorxml.mybatis.If;

/**
 *
 * @author T01BRQ0067
 */
public class IfXmlMybatis {

    public If buildIf(Coluna coluna,String concat) {
        StringBuilder buildString = new StringBuilder();
        if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {
            buildString.append(concat).append(Util.converteNomeColunaToAtri(coluna.getForengkey().getTabelaReferenciada())).append("!=null and ");
        }
        String nomeProperty = XmlMybatisUtil.getProperty(coluna);
        buildString.append(concat).append(nomeProperty).append("!=null");
        if ("varchar2".equalsIgnoreCase(coluna.getTipo())) {
            buildString.append(" and ").append(concat).append(nomeProperty).append("!=''");
        }
        If i = new If();
        i.setTest(buildString.toString());
        return i;
    }
}
