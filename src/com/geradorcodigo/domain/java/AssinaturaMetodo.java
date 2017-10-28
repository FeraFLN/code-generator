/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

import java.util.ArrayList;
import java.util.List;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.util.Util;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class AssinaturaMetodo {

    private String comentario;
    private List<String> anotacoes;
    private AcessibilidadeEnum acessibilidade;
    private Boolean statico;
    private Boolean metodoFinal;
    private String maiorMenor;
    private String retorno;
    private String nome;
    private List<AtributoMetodo> atributos;
    private Boolean abstrato;

    public AssinaturaMetodo(AssinaturaMetodo filho) {
        if(filho instanceof AssinaturaMetodo){
            this.comentario = filho.getComentario();
            this.anotacoes = filho.getAnotacoes();
            this.statico = filho.getStatico();
            this.acessibilidade = filho.getAcessibilidade();
            this.maiorMenor = filho.getMaiorMenor();
            this.retorno = filho.getRetorno();
            this.nome = filho.getNome();
            this.atributos = filho.getAtributos();
            this.abstrato = filho.getAbstrato();
        }
    }

    
    
    public AssinaturaMetodo() {
        atributos = new ArrayList<AtributoMetodo>();
    }

    public AssinaturaMetodo(String comentario, List<String> anotacoes, AcessibilidadeEnum acessibilidade, Boolean statico, Boolean metodoFinal, String maiorMenor, String retorno, String nome, List<AtributoMetodo> atributos, Boolean abstrato) {
        this.comentario = comentario;
        this.anotacoes = anotacoes;
        this.acessibilidade = acessibilidade;
        this.statico = statico;
        this.metodoFinal = metodoFinal;
        this.maiorMenor = maiorMenor;
        this.retorno = retorno;
        this.nome = nome;
        this.atributos = atributos;
        this.abstrato = abstrato;
    }

    public Boolean getAbstrato() {
        return abstrato;
    }

    public void setAbstrato(Boolean abstrato) {
        this.abstrato = abstrato;
    }

    public AcessibilidadeEnum getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(AcessibilidadeEnum acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public List<String> getAnotacoes() {
        if(anotacoes==null){
            anotacoes=new ArrayList<String>();
        }
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

    public String getMaiorMenor() {
        return maiorMenor;
    }

    public void setMaiorMenor(String maiorMenor) {
        this.maiorMenor = maiorMenor;
    }

    public Boolean getMetodoFinal() {
        return metodoFinal;
    }

    public void setMetodoFinal(Boolean metodoFinal) {
        this.metodoFinal = metodoFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public Boolean getStatico() {
        return statico;
    }

    public void setStatico(Boolean statico) {
        this.statico = statico;
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
        //retornoString +=StringUtils.join(anotacoes,"\n");
        if (acessibilidade != null) {
            retornoString += acessibilidade.getValue() + " ";
        }
        if (new Boolean(true).equals(abstrato)) {
            retornoString += "abstract ";
        }
        if (new Boolean(true).equals(statico)) {
            retornoString += "static ";
        }
        if (new Boolean(true).equals(getMetodoFinal())) {
            retornoString += "final ";
        }
        if (maiorMenor != null && !maiorMenor.isEmpty()) {
            retornoString += "<" + maiorMenor + "> ";
        }
        if (retorno != null && !retorno.isEmpty()) {
            retornoString += retorno + " ";
        } else {
            retornoString += "void ";
        }
        if (getNome() != null) {
            retornoString += getNome() + "(";
        }
        String atri = Util.getString(StringUtils.join(atributos, ","));
        if (!"".equals(atri)) {
            retornoString += atri;
        }

        retornoString += ");\n";


        return retornoString;
    }
}
