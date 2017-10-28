/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.exception;

/**
 *
 * @author T01BRQ0067
 */
public class GeradorException extends Exception{
    private static final long serialVersionUID = 1L;

    private String detalhe;
    
    public GeradorException() {
    }

    public GeradorException( String message,String detalhe) {
        super(message);
        this.detalhe = detalhe;
    }

    public GeradorException(String message) {
        super(message);
    }

    public GeradorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeradorException(Throwable cause) {
        super(cause);
    }

    public String getDetalhe() {
        return detalhe;
    }
    
    
    
}
