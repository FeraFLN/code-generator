/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis.exception;

import com.geradorcodigo.exception.GeradorException;

/**
 *
 * @author T01BRQ0067
 */
public class XmlMybatisException extends GeradorException{
    private static final long serialVersionUID = 1L;
    
    public XmlMybatisException(Throwable cause) {
        super(cause);
    }

    public XmlMybatisException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlMybatisException(String message) {
        super(message);
    }

    public XmlMybatisException(String message, String detalhe) {
        super(message, detalhe);
    }

    public XmlMybatisException() {
    }


    
}
