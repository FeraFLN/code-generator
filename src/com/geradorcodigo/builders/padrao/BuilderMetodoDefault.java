/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.padrao;

import com.geradorcodigo.builders.padrao.getset.MetodoGet;
import com.geradorcodigo.builders.padrao.getset.MetodoSet;
import com.geradorcodigo.builders.padrao.outros.MetodoEquals;
import com.geradorcodigo.builders.padrao.outros.MetodoHash;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.domain.java.atributotipado.AtributoSerializabled;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderMetodoDefault {

    private List<Metodo> metodos;
    private List<Atributo> atributos;

    public BuilderMetodoDefault(List<Atributo> atributos) {
        this.metodos = new LinkedList<Metodo>();
        this.atributos = atributos;
    }

    public BuilderMetodoDefault builderGets() {
        for (Atributo atributo : atributos) {
            if(atributo instanceof AtributoSerializabled){
                continue;
            }
            metodos.add(new MetodoGet().getMetodo(atributo));
        }
        return this;
    }

    public BuilderMetodoDefault builderSets() {
        for (Atributo atributo : atributos) {
            if(atributo instanceof AtributoSerializabled){
                continue;
            }
            metodos.add(new MetodoSet().getMetodo(atributo));
        }
        return this;
    }

    public BuilderMetodoDefault builderGetsSets() {
        for (Atributo atributo : atributos) {
            if(atributo instanceof AtributoSerializabled){
                continue;
            }
            metodos.add(new MetodoSet().getMetodo(atributo));
            metodos.add(new MetodoGet().getMetodo(atributo));
        }
        return this;
    }

    public BuilderMetodoDefault builderEquals(String nomeClasse) {
        metodos.add(new MetodoEquals(nomeClasse).getMetodo(atributos));
        return this;
    }

    public BuilderMetodoDefault builderHashCode() {
        metodos.add(new MetodoHash().getMetodo(atributos));
        return this;
    }

    public List<Metodo> build() {
        return metodos;
    }
}
