/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders;

import com.geradorcodigo.exception.GeradorException;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderException extends GeradorException{
    private static final long serialVersionUID = 1L;

    public BuilderException(Throwable cause) {
        super(cause);
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(String detalhe, String message) {
        super(detalhe, message);
    }

    public BuilderException() {
    }
   
    
}
