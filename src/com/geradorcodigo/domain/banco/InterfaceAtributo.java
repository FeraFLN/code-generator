/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.banco;

/**
 *
 * @author T01BRQ0067
 */
public interface InterfaceAtributo {
    public String getNomeTabela();
    public String getNome();
    public String getComentario();
    public String getTipo();
    public Integer getTamanho();
    public Boolean getNullable();
    public Boolean getPrimaryKey();
    public Check getCheck();
    public Forengkey getForengkey();
    
    
    
    
}
