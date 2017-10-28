/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

import java.util.List;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.util.Util;

/**
 *
 * @author T01BRQ0067
 */
public class Metodo extends AssinaturaMetodo {

    private String corpo;

    public Metodo() {
        super();
    }

    public Metodo(String comentario, List<String> anotacoes, AcessibilidadeEnum acessibilidade, Boolean statico, Boolean metodoFinal, String maiorMenor, String retorno, String nome, List<AtributoMetodo> atributos, String corpo, Boolean abstrato) {
        super(comentario, anotacoes, acessibilidade, statico, metodoFinal, maiorMenor, retorno, nome, atributos, abstrato);
        this.corpo = corpo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        String retornoString = "";
        String assinatura = super.toString();
        if (!Boolean.TRUE.equals(getAbstrato())) {
            retornoString = assinatura.substring(0, assinatura.length() - 2) + "{\n";
            if (corpo != null) {
                retornoString += Util.tabLineString(corpo, "\t");
            }
            retornoString += "}";
        }else{
            retornoString = assinatura;
        }
        return retornoString;
    }
}
