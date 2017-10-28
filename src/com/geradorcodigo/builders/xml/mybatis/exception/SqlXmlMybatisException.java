/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis.exception;

/**
 *
 * @author T01BRQ0067
 */
public class SqlXmlMybatisException extends XmlMybatisException{
    private static final long serialVersionUID = 1L;

    public SqlXmlMybatisException() {
    }

    public SqlXmlMybatisException(String message) {
        super(message);
    }

    public SqlXmlMybatisException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlXmlMybatisException(String message, String detalhamento) {
        super(message, detalhamento);
    }

    public SqlXmlMybatisException(Throwable cause) {
        super(cause);
    }
    
}
