/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.banco;

import com.geradorcodigo.util.Util;
import java.util.List;

public class Forengkey {

    private String nome;
    private String tabelaReferenciada;
    private String colunaReferenciada;
    

    public Forengkey(String nome, String tabelaReferenciada,String colunaReferenciada) {
        this.nome = nome;
        this.tabelaReferenciada = tabelaReferenciada;
        this.colunaReferenciada = colunaReferenciada;
    }

    public Forengkey() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTabelaReferenciada() {
        return tabelaReferenciada;
    }

    public String getColunaReferenciada() {
        return colunaReferenciada;
    }

    public void setColunaReferenciada(String colunaReferenciada) {
        this.colunaReferenciada = colunaReferenciada;
    }

    public void setTabelaReferenciada(String tabelaReferenciada) {
        this.tabelaReferenciada = tabelaReferenciada;
    }

    @Override
    public String toString() {
        return  Util.getString(nome) +   Util.getString(tabelaReferenciada);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Forengkey other = (Forengkey) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.tabelaReferenciada == null) ? (other.tabelaReferenciada != null) : !this.tabelaReferenciada.equals(other.tabelaReferenciada)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 61 * hash + (this.tabelaReferenciada != null ? this.tabelaReferenciada.hashCode() : 0);
        return hash;
    }
    public boolean isEmpty(){
        if((nome == null|| nome.isEmpty())&&(tabelaReferenciada==null||tabelaReferenciada.isEmpty())){
            return true;
        }
        return false;
    }
}

