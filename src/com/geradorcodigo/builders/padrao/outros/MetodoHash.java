/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.padrao.outros;

import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.domain.java.atributotipado.AtributoSerializabled;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author T01BRQ0067
 */
public class MetodoHash implements MetodoDefault{

    @Override
    public Metodo getMetodo(List<Atributo> atributos) {
        Random rand = new Random();
        int hash = rand.nextInt((10 - 1) + 1) + 1;
        int value = rand.nextInt((100 - 10) + 10) + 10;
        StringBuilder corpo = new StringBuilder();
         corpo.append("int hash = ")
                    .append(hash)
                    .append(";\n");
        for (Atributo atributo : atributos) {
            if(atributo instanceof AtributoSerializabled){
                continue;
            }
            corpo.append("hash = ")
                    .append(value)
                    .append(" * hash + ")
                    .append("(this.")
                    .append(atributo.getNome())
                    .append(" != null ? ")
                    .append("this.")
                    .append(atributo.getNome())
                    .append(".hashCode()")
                    .append(" : 0);\n");
                    
        }
        corpo.append("return hash;\n");
        return new Metodo(null,
                Arrays.asList("@Override"),
                AcessibilidadeEnum.PUBLIC,
                Boolean.FALSE,
                Boolean.FALSE,
                null,
                "int",
                "hashCode",
                null,
                corpo.toString(),
                Boolean.FALSE);
    }
    
}
