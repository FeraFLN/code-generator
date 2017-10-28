/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.dao;

import com.geradorcodigo.exception.GeradorException;

/**
 *
 * @author T01BRQ0067
 */
public class ConexaoException extends GeradorException{
    private static final long serialVersionUID = 1L;

    public ConexaoException(String message) {
        super(message);
    }

    public ConexaoException(String message,String detalhe) {
        super( message,detalhe);
    }

    public ConexaoException() {
    }
    
    
    
    
}
