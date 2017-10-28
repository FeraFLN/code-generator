/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.padrao.getset;

import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class MetodoGet implements MetodoGetSet {

    @Override
    public Metodo getMetodo(Atributo atributo) {
        StringBuilder nomeGet = new StringBuilder(atributo.getTipo().equalsIgnoreCase("boolean") ? "is" : "get");
        nomeGet.append(StringUtils.capitalize(atributo.getNome()));
        Metodo metodo = new Metodo(null, null, AcessibilidadeEnum.PUBLIC,
                Boolean.FALSE, Boolean.FALSE,
                null, atributo.getTipo(),
                nomeGet.toString(),
                null, "return " + atributo.getNome() + ";",
                Boolean.FALSE);
        return metodo;
    }
}
