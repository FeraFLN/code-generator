/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.padrao.outros;

import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.AtributoMetodo;
import com.geradorcodigo.domain.java.ClasseJava;
import com.geradorcodigo.domain.java.ConstrutorJava;
import com.geradorcodigo.domain.java.atributotipado.AtributoSerializabled;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ConstrutorDefault {
    

    
    
    public ConstrutorJava getConstrutor(String nomeClasse) {
        return getConstrutor(nomeClasse, new ArrayList<Atributo>());
    }
    public ConstrutorJava getConstrutor(String nomeClasse, Atributo atributo) {
        return getConstrutor(nomeClasse, Arrays.asList(atributo));
    }
    
    public ConstrutorJava getConstrutor(String nomeClasse, List<Atributo> list) {
        String nomeClasseAux ="";
        StringBuilder corpo = new StringBuilder();
        if(nomeClasse!=null ){
            nomeClasseAux=nomeClasse;
        }
        
        ConstrutorJava construtorJava = new ConstrutorJava(nomeClasseAux);
        for (Atributo atributo : list) {
            if (atributo instanceof AtributoSerializabled) {
                continue;
            }
            corpo.append("this.").append(atributo.getNome()).append("=").append(atributo.getNome()).append(";");
            construtorJava.getAtributos().add(new AtributoMetodo(atributo));
        }
        construtorJava.setCorpo(corpo.toString());
        construtorJava.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        return construtorJava;
    }
    
    public ConstrutorJava getConstrutor(ClasseJava classeJava) {
        if (classeJava == null) {
            return null;
        }
        return getConstrutor(classeJava.getNome(), (Atributo) classeJava.getAtributos());
    }
    
    
}
