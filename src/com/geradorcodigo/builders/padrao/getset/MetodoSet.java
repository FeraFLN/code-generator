/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.padrao.getset;

import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.AtributoMetodo;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class MetodoSet implements MetodoGetSet {

    @Override
    public Metodo getMetodo(Atributo atributo) {
        Metodo metodo = new Metodo(null,
                null,
                AcessibilidadeEnum.PUBLIC,
                Boolean.FALSE,
                Boolean.FALSE,
                null,
                null,
                "set" + StringUtils.capitalize(atributo.getNome()),
                Arrays.asList(new AtributoMetodo(atributo)),
                "this." + atributo.getNome() + " = " + atributo.getNome() + ";",
                Boolean.FALSE);
        return metodo;
    }
}
