/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.exception.generica;

import com.geradorcodigo.exception.GeradorException;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderGenericException extends GeradorException{
    private static final long serialVersionUID = 1L;

    public BuilderGenericException(Throwable cause) {
        super(cause);
    }

    public BuilderGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuilderGenericException(String message) {
        super(message);
    }

    public BuilderGenericException(String message, String detalhe) {
        super(message, detalhe);
    }

    public BuilderGenericException() {
    }
    
}
