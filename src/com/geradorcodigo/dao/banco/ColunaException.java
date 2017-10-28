/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.dao.banco;

import com.geradorcodigo.exception.GeradorException;

/**
 *
 * @author T01BRQ0067
 */
public class ColunaException extends GeradorException{
    private static final long serialVersionUID = 1L;

    public ColunaException(Throwable cause) {
        super(cause);
    }

    public ColunaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColunaException(String message) {
        super(message);
    }

    public ColunaException(String detalhe, String message) {
        super(detalhe, message);
    }

    public ColunaException() {
    }
    
}
