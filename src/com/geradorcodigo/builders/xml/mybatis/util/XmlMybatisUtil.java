/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis.util;

import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.jdbctype.JdbcType;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class XmlMybatisUtil {

    public static String buildTagSql(List<Coluna> colunas) throws GeradorException {
        StringBuilder resultado = new StringBuilder();
        Iterator<Coluna> iColuna = colunas.iterator();
        resultado.append("\n");
        while (iColuna.hasNext()) {
            Coluna coluna = iColuna.next();
            resultado.append("#{").append(getProperty(coluna));
            jdbcTypeConcat(resultado, coluna, true);
            resultado.append("}");
            if (iColuna.hasNext()) {
                resultado.append(",");
                resultado.append("\n");
            }
        }
        return resultado.toString();
    }

    public static List<Coluna> idColunasSql(List<Coluna> colunas) {
        List<Coluna> c = new ArrayList<Coluna>();
        for (Coluna coluna : colunas) {
            if (coluna.getPrimaryKey()) {
                c.add(coluna);
            }
        }
        return c;
    }

    public static String buildColunasSql(List<Coluna> colunas) {
        return buildColunasSql(colunas, false);
    }
    public static String buildColunasSql(List<Coluna> colunas, boolean quebraLinha) {
        StringBuilder resultado = new StringBuilder();
        Iterator<Coluna> iColuna = colunas.iterator();
//        resultado.append("\n");
        while (iColuna.hasNext()) {
            Coluna coluna = iColuna.next();
            resultado.append(coluna.getNome());
            if (iColuna.hasNext()) {
                resultado.append(",");
                if(quebraLinha){
                    resultado.append("\n");
                }
            }
        }
        return com.geradorcodigo.util.Util.tabLineString(resultado.toString(), "\t\t");

    }

    public static String buildCondicaoSql(Coluna coluna) throws GeradorException {
        List<Coluna> colunas = Arrays.asList(coluna);
        return buildCondicaoSql(colunas);
    }

    public static String buildSetUpdateSql(List<Coluna> colunas) throws GeradorException {
        return buildCondicaoSql(colunas, ", ", true,true);

    }

    public static String buildCondicaoSql(List<Coluna> colunas) throws GeradorException {
        return buildCondicaoSql(colunas, " and ", false,false);
    }

    private static void jdbcTypeConcat(StringBuilder resultado,Coluna coluna,boolean jdbcType) throws GeradorException{
        if(jdbcType && coluna.getNullable()){
                resultado.append(", jdbcType=").append(JdbcType.getMapJdbcType(coluna.getTipo().toUpperCase()));
            }
    }
    
    private static String buildCondicaoSql(List<Coluna> colunas, String separdor, boolean quebraLinha,boolean jdbcType) throws GeradorException {
        StringBuilder resultado = new StringBuilder();
        Iterator<Coluna> iColuna = colunas.iterator();
        while (iColuna.hasNext()) {
            Coluna coluna = iColuna.next();
            resultado.append(coluna.getNome()).append("=#{").append(getProperty(coluna));
            jdbcTypeConcat(resultado, coluna, jdbcType);
            resultado.append("}");
            if (iColuna.hasNext()) {
                resultado.append(separdor);
                if (quebraLinha) {
                    resultado.append("\n");
                }
            }
        }
        return resultado.toString();
    }

    public static String getProperty(Coluna coluna) {
        String retorno = "";
        if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {
            retorno = Util.converteNomeColunaToAtri(coluna.getForengkey().getTabelaReferenciada()) + ".";
            retorno += Util.converteNomeColunaToAtri(coluna.getForengkey().getColunaReferenciada());
             return retorno;
        }
        retorno += Util.converteNomeColunaToAtri(coluna.getNome());
        return retorno;
    }
}
