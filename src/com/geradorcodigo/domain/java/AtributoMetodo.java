/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

/**
 *
 * @author T01BRQ0067
 */
public class AtributoMetodo {
    private Boolean atributoFinal;
    private String tipo;
    private String nome;

    public AtributoMetodo() {
    }
    public AtributoMetodo(AtributoMetodo filho) {
        if(filho instanceof AtributoMetodo){
            this.atributoFinal = filho.getAtributoFinal();
            this.tipo = filho.getTipo();
            this.nome = filho.getNome();
        }
    }

    public AtributoMetodo(Boolean atributoFinal, String tipo, String nome) {
        this.atributoFinal = atributoFinal;
        this.tipo = tipo;
        this.nome = nome;
    }

    
    
    public Boolean getAtributoFinal() {
        return atributoFinal;
    }

    public void setAtributoFinal(Boolean atributoFinal) {
        this.atributoFinal = atributoFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtributoMetodo other = (AtributoMetodo) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    
    @Override
    public String toString() {
        String retorno ="";
        if(Boolean.TRUE.equals(getAtributoFinal())){
            retorno +="final ";
        }
        if(getTipo()!=null){
            retorno+=getTipo()+" ";
        }
        if(getNome()!=null){
            retorno+=getNome();
        }
        return retorno;
    }
    
    
    
}
