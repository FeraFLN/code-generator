/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.enums;

/**
 *
 * @author T01BRQ0067
 */
public enum TipoObjetoEnum {
    CLASS("class"),
    ENUM("enum"),
    INTERFACE("interface");
    
    private String value;

    private TipoObjetoEnum(String value) {
        this.value = value;
    }
    private TipoObjetoEnum() {
    }

    public String getValue() {
        return value;
    }
    
}
