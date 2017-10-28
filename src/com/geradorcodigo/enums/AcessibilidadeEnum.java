/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.enums;

/**
 *
 * @author T01BRQ0067
 */
public enum AcessibilidadeEnum {
    PUBLIC("public"),
    PRIVATE("private"),
    PROTECTED("protected");
    
    private String value;

    private AcessibilidadeEnum(String valor) {
        this.value = valor;
    }

    public String getValue() {
        return value;
    }
    public static AcessibilidadeEnum value(String _displayValue) {
		for (AcessibilidadeEnum _enum : AcessibilidadeEnum.values()) {
			if (_enum.value.equals(_displayValue)) {
				return _enum;
			}
		}
		return null;
	}
}
