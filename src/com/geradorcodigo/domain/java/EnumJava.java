/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

import java.util.List;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.enums.TipoObjetoEnum;
import com.geradorcodigo.util.Util;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class EnumJava {

    private String comentarioInicial;
    private String pkg;
    private List<String> importacoes;
    private String comentarioClasse;
    private List<String> anotacoes;
    private String nome;
    private List<String> enums;
    private List<Atributo> atributos;
    private List<Metodo> metodos;
    private List<ConstrutorJava> construtores;

    public EnumJava() {
    }

    public EnumJava(String comentarioInicial, String pkg, List<String> importacoes, String comentarioClasse, List<String> anotacoes, String nome, List<String> enums, List<Atributo> atributos, List<Metodo> metodos,List<ConstrutorJava> construtores) {
        this.comentarioInicial = comentarioInicial;
        this.pkg = pkg;
        this.importacoes = importacoes;
        this.comentarioClasse = comentarioClasse;
        this.anotacoes = anotacoes;
        this.nome = nome;
        this.enums = enums;
        this.atributos = atributos;
        this.metodos = metodos;
        this.construtores = construtores;
        
    }


    public List<String> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<String> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public String getComentarioClasse() {
        return comentarioClasse;
    }

    public void setComentarioClasse(String comentarioClasse) {
        this.comentarioClasse = comentarioClasse;
    }

    public String getComentarioInicial() {
        return comentarioInicial;
    }

    public void setComentarioInicial(String comentarioInicial) {
        this.comentarioInicial = comentarioInicial;
    }

    public List<String> getEnums() {
        return enums;
    }

    public void setEnums(List<String> enums) {
        this.enums = enums;
    }

    public List<String> getImportacoes() {
        return importacoes;
    }

    public void setImportacoes(List<String> importacoes) {
        this.importacoes = importacoes;
    }

    public List<Metodo> getMetodos() {
        return metodos;
    }

    public void setMetodos(List<Metodo> metodos) {
        this.metodos = metodos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public List<ConstrutorJava> getConstrutores() {
        return construtores;
    }

    public void setConstrutores(List<ConstrutorJava> construtores) {
        this.construtores = construtores;
    }
    
    @Override
    public String toString() {
        String retorno = "";
        if (comentarioInicial != null && !comentarioInicial.isEmpty()) {
            retorno += comentarioInicial + "\n\n";
        }
        if (pkg != null && !pkg.isEmpty()) {
            retorno += "package " + pkg + "\n\n";
        }
        if (importacoes != null && !importacoes.isEmpty()) {
            retorno += StringUtils.join(importacoes, "\n") + "\n\n";
        }
        if (comentarioClasse != null && !comentarioClasse.isEmpty()) {
            retorno += comentarioClasse + "\n\n";
        }
        if (anotacoes != null && !anotacoes.isEmpty()) {
            retorno += StringUtils.join(anotacoes, "\n") + "\n";
        }
            retorno += Util.getString(AcessibilidadeEnum.PUBLIC.getValue()) + " ";
        retorno += TipoObjetoEnum.ENUM.getValue() + " ";
        if (nome != null && !nome.isEmpty()) {
            retorno += Util.getString(nome) + " ";
        }

        retorno += "{\n\n";
        if (enums != null && !enums.isEmpty()) {
            retorno += "\t"+StringUtils.join(enums, ",") + ";\n\n";
        }
        if (atributos != null && !atributos.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(atributos, "\n"), "\t") + "\n";
        }
        if (construtores != null && !construtores.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(construtores, "\n"), "\t") + "\n";
        }
        if (metodos != null && !metodos.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(metodos, "\n"), "\t") + "\n";
        }

        retorno += "}";
        return retorno;
    }
}
