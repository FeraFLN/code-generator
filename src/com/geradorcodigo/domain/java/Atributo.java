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
public class Atributo extends AtributoMetodo {

    private String comentario;
    private List<String> anotacoes;
    private AcessibilidadeEnum acessibilidade;
    private Boolean statico;
    private String valor;

    public Atributo(String comentario, List<String> anotacoes, AcessibilidadeEnum acessibilidade, Boolean statico, Boolean atributoFinal, String tipo, String nome, String valor) {
        super(atributoFinal, tipo, nome);
        this.comentario = comentario;
        this.anotacoes = anotacoes;
        this.acessibilidade = acessibilidade;
        this.statico = statico;
        this.valor = valor;
    }

    public Atributo() {
        anotacoes = new ArrayList<String>();
    }

    public List<String> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<String> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public AcessibilidadeEnum getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(AcessibilidadeEnum acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public Boolean getStatico() {
        return statico;
    }

    public void setStatico(Boolean statico) {
        this.statico = statico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atributo other = (Atributo) obj;
        
        return other.getNome().contains(other.getNome());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
    
    @Override
    public String toString() {
        String retorno = "";
        if (comentario != null) {
            retorno += comentario + "\n";
        }
        String anot = Util.getString(StringUtils.join(anotacoes ,"\n"));
        if(!"".equals(anot)){
            retorno+=anot+"\n";
        }
        if (acessibilidade != null) {
            retorno += acessibilidade.getValue() + " ";
        }
        if (new Boolean(true).equals(statico)) {
            retorno += "static ";
        }
        retorno += super.toString();

        if (valor != null && !valor.equals("")) {
            retorno += " = " + valor;
        }
        retorno += ";";
        return retorno;
    }
}
