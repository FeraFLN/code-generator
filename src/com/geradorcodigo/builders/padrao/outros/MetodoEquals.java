/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.padrao.outros;

import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.AtributoMetodo;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.domain.java.atributotipado.AtributoSerializabled;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class MetodoEquals implements MetodoDefault{
    private String nomeClasse="";

    public MetodoEquals(String nomeClasse) {
        this.nomeClasse=nomeClasse;
    }
    
    @Override
    public Metodo getMetodo(List<Atributo> atributos) {
        StringBuilder corpo = new StringBuilder();
        String classe = (nomeClasse!=null && !nomeClasse.isEmpty()?nomeClasse:"Object");
        corpo.append("if(obj == null){\n\treturn false;\n}\n")
              .append("if (getClass() != obj.getClass()) {\n\treturn false;\n}\n")
              .append("final ")
                 .append(classe)
                 .append(" other = (")
                 .append(classe)
                 .append(") obj;\n"); 
        for (Atributo atributo : atributos) {
            if(atributo instanceof AtributoSerializabled){
                continue;
            }
            if("String".equals(atributo.getTipo())){
                corpo.append("if ((this.")
                        .append(atributo.getNome())
                        .append(" == null) ? (other.")
                        .append(atributo.getNome())
                        .append(" != null) : !this.")
                        .append(atributo.getNome())
                        .append(".equals(other.")
                        .append(atributo.getNome())
                        .append(")) {\n\treturn false;\n}\n");
            }else{
                corpo.append("if (this.")
                        .append(atributo.getNome())
                        .append(" != other.")
                        .append(atributo.getNome())
                        .append(" && (this.")
                        .append(atributo.getNome())
                        .append(" == null || !this.")
                        .append(atributo.getNome())
                        .append(".equals(other.")
                        .append(atributo.getNome())
                        .append("))) {\n\treturn false;\n}\n");
            }
        }
        corpo.append("return true;\n");
        return new Metodo(null,
                Arrays.asList("@Override"),
                AcessibilidadeEnum.PUBLIC,
                Boolean.FALSE,
                Boolean.FALSE,
                null,
                "boolean",
                "equals",
                Arrays.asList(new AtributoMetodo(Boolean.FALSE, "Object", "obj")),
                corpo.toString(),
                Boolean.FALSE);
    }
    
}
