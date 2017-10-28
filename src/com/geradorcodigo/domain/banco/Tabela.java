/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.banco;

/**
 *
 * @author T01BRQ0067
 */
public class Tabela {
    private String owner;
    private String nome;
    private String comentario;

    public Tabela(String owner, String nome, String comentario) {
        this.owner = owner;
        this.nome = nome;
        this.comentario = comentario;
    }

    public Tabela(String owner, String nome) {
        this.owner = owner;
        this.nome = nome;
    }
    
    

    public Tabela() {
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Tabela{" + "owner=" + owner + ", nome=" + nome + ", comentario=" + comentario + '}';
    }

    
    
    
            
}
