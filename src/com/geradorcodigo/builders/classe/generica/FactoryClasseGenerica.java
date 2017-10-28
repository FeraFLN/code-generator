/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.classe.generica;

import com.geradorcodigo.builders.AbstractBuilder;
import com.geradorcodigo.domain.java.ObjetoJava;
import com.geradorcodigo.exception.GeradorException;
import java.lang.reflect.Constructor;

/**
 *
 * @author T01BRQ0067
 */
public class FactoryClasseGenerica {


    @SuppressWarnings("unchecked")
     public static AbstractBuilder<? extends ObjetoJava> getNewInstance(Class<? extends AbstractBuilder<? extends ObjetoJava>> clazz,Object o, String nomeDesenvovedor, String pkg) throws GeradorException {
        try {
            Constructor<? extends AbstractBuilder<? extends ObjetoJava>> ctor = clazz.getConstructor(Object.class,String.class,String.class);
            return ctor.newInstance(o, nomeDesenvovedor, pkg);
        } catch (Exception ex) {
            throw new GeradorException("Erro a criar o construtor.", ex.getMessage());
        }
    }
}
