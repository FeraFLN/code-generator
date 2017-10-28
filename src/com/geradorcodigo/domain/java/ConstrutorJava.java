/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

import java.util.List;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class ConstrutorJava {

    private String comentario;
    private List<String> anotacoes;
    private AcessibilidadeEnum acessibilidade;
    private String maiorMenor;
    private String nome;
    private List<AtributoMetodo> atributos;
    private String corpo;

    
    public ConstrutorJava(String nome) {
        this.acessibilidade=AcessibilidadeEnum.PUBLIC;
        this.nome=nome;
        this.atributos = new ArrayList<AtributoMetodo>();
        this.anotacoes = new ArrayList<String>();
    }

    public ConstrutorJava(String comentario, List<String> anotacoes, AcessibilidadeEnum acessibilidade, String maiorMenor, String nome, List<AtributoMetodo> atributos, String corpo) {
        this.comentario = comentario;
        this.anotacoes = anotacoes;
        this.acessibilidade = acessibilidade;
        this.maiorMenor = maiorMenor;
        this.nome = nome;
        this.atributos = atributos;
        this.corpo = corpo;
    }

    public AcessibilidadeEnum getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(AcessibilidadeEnum acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public List<String> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<String> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<AtributoMetodo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<AtributoMetodo> atributos) {
        this.atributos = atributos;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getMaiorMenor() {
        return maiorMenor;
    }

    public void setMaiorMenor(String maiorMenor) {
        this.maiorMenor = maiorMenor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String retornoString = "";
        if (comentario != null && !comentario.isEmpty()) {
            retornoString += comentario + "\n";
        }
        String anot = Util.getString(StringUtils.join(anotacoes, "\n"));
        if (!"".equals(anot)) {
            retornoString += anot + "\n";
        }
        if (acessibilidade != null) {
            retornoString += acessibilidade.getValue() + " ";
        }
        if (maiorMenor != null && !maiorMenor.isEmpty()) {
            retornoString += "<" + maiorMenor + "> ";
        }
        if (getNome() != null) {
            retornoString += getNome() + "(";
        }
        String atri = Util.getString(StringUtils.join(atributos, ","));
        if (!"".equals(atri)) {
            retornoString += atri;
        }

        retornoString += "){\n";
        if (corpo != null) {
            retornoString += Util.tabLineString(corpo, "\t");
        }
        retornoString += "}";
        return retornoString;
    }
}
