/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis.exception;

/**
 *
 * @author T01BRQ0067
 */
public class SelectGenericsXmlException extends XmlMybatisException{
    private static final long serialVersionUID = 1L;

    public SelectGenericsXmlException() {
    }

    public SelectGenericsXmlException(String message, String detalhe) {
        super(message, detalhe);
    }

    public SelectGenericsXmlException(String message) {
        super(message);
    }

    public SelectGenericsXmlException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectGenericsXmlException(Throwable cause) {
        super(cause);
    }
    
    
}
