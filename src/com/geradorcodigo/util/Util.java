/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.util;

import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.banco.Forengkey;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class Util {

    public static String converteNomeTabelaToClasse(String nome) {
        return StringUtils.capitalize(converteNomeColunaToAtri(nome));
    }

     public static String converteNomeColunaToAtri(String nome) {
        if (nome == null) {
            return null;
        }
        String retorno = StringUtils.lowerCase(nome.replace(" ", ""));
        Pattern pattern = Pattern.compile("((_)(\\w))");
        Matcher matcher = pattern.matcher(retorno);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(3).toUpperCase()); 
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
    
    public static List<Coluna> replaceFks(List<Coluna> colunas,String comentarioDefault) {
        List<Coluna> retorno = new ArrayList<Coluna>();
        List<Forengkey> conteiner = new ArrayList<Forengkey>();
        for (Coluna coluna : colunas) {
            if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {
                conteiner.add(coluna.getForengkey());
                
                String comentario ="/*ESSE ATRIBUTO FAZ REFERENCIA A TABELA: \""
                                    +coluna.getForengkey().getTabelaReferenciada()
                                    +"\" FK \""+coluna.getForengkey().getNome()+"\"*/";
                retorno.add(new Coluna( coluna.getPrimaryKey(),
                                        coluna.getTabela(), 
                                        coluna.getNome(), 
                                        coluna.getForengkey().getTabelaReferenciada(), 
                                        null, 
                                        coluna.getNullable(), 
                                        comentario, 
                                        null, 
                                        coluna.getForengkey()));
            } else {
                if(comentarioDefault!= null && !"".equals(comentarioDefault)){
                    coluna.setComentario(comentarioDefault.replace("[NOME_COLUNA]", coluna.getNome()).toUpperCase());
                }
                retorno.add(coluna);
            }
        }
        return retorno;
    }
    

    public static String getString(String valor) {
        if (valor == null) {
            return "";
        }
        return valor;
    }

    public static String tabLineString(String valor, String tabulacao) {
        return tabString(valor, "\n", tabulacao);
    }

    public static String tabString(String valor, String delimitador) {
        return tabString(valor, delimitador, "\t");
    }

    public static String tabString(String valor, String delimitador, String tabulacao) {
        if (valor == null) {
            return "";
        }
        if (delimitador == null || delimitador.isEmpty()) {
            delimitador = "\n";
        }
        if (tabulacao == null || tabulacao.isEmpty()) {
            tabulacao = "\t";
        }
        List<String> linhas = Arrays.asList(valor.split(delimitador));
        String retorno = "";
        for (String string : linhas) {
            retorno += tabulacao + string + delimitador;
        }
        return retorno;
    }
    public static String incluiFileSeparator(String valor) {
        if (valor == null || valor.isEmpty()) {
            return valor;
        }
        return (valor.endsWith(File.separator) ? valor : valor + File.separator);
    }

}
