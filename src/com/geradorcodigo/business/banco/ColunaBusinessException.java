/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.business.banco;

import com.geradorcodigo.exception.GeradorException;

/**
 *
 * @author T01BRQ0067
 */
public class ColunaBusinessException extends GeradorException{

    public ColunaBusinessException(Throwable cause) {
        super(cause);
    }

    public ColunaBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColunaBusinessException(String message) {
        super(message);
    }

    public ColunaBusinessException(String detalhe, String message) {
        super(detalhe, message);
    }

    public ColunaBusinessException() {
    }
    
}
