/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

import java.util.List;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.enums.TipoObjetoEnum;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class ClasseJava implements ObjetoJava{

    private String comentarioInicial;
    private String pkg;
    private List<String> importacoes;
    private String comentarioClasse;
    private List<String> anotacoes;
    private AcessibilidadeEnum acessibilidade;
    private Boolean objetoAbstrato;
    private Boolean finalObject;
    private String nome;
    private String maiorMenor;
    private String objetoExtendido;
    private List<String> objetosImplementados;
    private List<Atributo> atributos;
    private List<ConstrutorJava> construtores;
    private List<Metodo> metodos;

    public ClasseJava() {
        this.importacoes = new ArrayList<String>();
        this.anotacoes = new ArrayList<String>();
        this.objetosImplementados = new ArrayList<String>();
        this.atributos = new ArrayList<Atributo>();
        this.construtores = new ArrayList<ConstrutorJava>();
        this.metodos = new ArrayList<Metodo>();
    }

    public ClasseJava(String comentarioInicial, String pkg, List<String> importacoes, String comentarioClasse, List<String> anotacoes, AcessibilidadeEnum acessibilidade, Boolean objetoAbstrato, Boolean finalObject, String nome, String maiorMenor, String objetoExtendido, List<String> objetosImplementados, List<Atributo> atributos, List<ConstrutorJava> construtores, List<Metodo> metodos) {
        this.comentarioInicial = comentarioInicial;
        this.pkg = pkg;
        this.importacoes = importacoes;
        this.comentarioClasse = comentarioClasse;
        this.anotacoes = anotacoes;
        this.acessibilidade = acessibilidade;
        this.objetoAbstrato = objetoAbstrato;
        this.finalObject = finalObject;
        this.nome = nome;
        this.maiorMenor = maiorMenor;
        this.objetoExtendido = objetoExtendido;
        this.objetosImplementados = objetosImplementados;
        this.atributos = atributos;
        this.construtores = construtores;
        this.metodos = metodos;
    }

    

    public AcessibilidadeEnum getAcessibilidade() {
        return acessibilidade;
    }

    @Override
    public void setAcessibilidade(AcessibilidadeEnum acessibilidade) {
        this.acessibilidade = acessibilidade;
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

    public Boolean getFinalObject() {
        return finalObject;
    }

    public void setFinalObject(Boolean finalObject) {
        this.finalObject = finalObject;
    }

    public List<String> getImportacoes() {
        return importacoes;
    }

    public void setImportacoes(List<String> importacoes) {
        this.importacoes = importacoes;
    }

    public String getMaiorMenor() {
        return maiorMenor;
    }

    @Override
    public void setMaiorMenor(String maiorMenor) {
        this.maiorMenor = maiorMenor;
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

    public Boolean getObjetoAbstrato() {
        return objetoAbstrato;
    }

    @Override
    public void setObjetoAbstrato(Boolean objetoAbstrato) {
        this.objetoAbstrato = objetoAbstrato;
    }

    public String getObjetoExtendido() {
        return objetoExtendido;
    }

    @Override
    public void setObjetoExtendido(String objetoExtendido) {
        this.objetoExtendido = objetoExtendido;
    }

    public List<String> getObjetosImplementados() {
        return objetosImplementados;
    }

    @Override
    public void setObjetosImplementados(List<String> objetosImplementados) {
        this.objetosImplementados = objetosImplementados;
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
            retorno += comentarioInicial + "\n";
        }
        if (pkg != null && !pkg.isEmpty()) {
            retorno += "package " + pkg + ";\n";
        }
        if (importacoes != null && !importacoes.isEmpty()) {
            retorno += StringUtils.join(importacoes, "\n") + "\n";
        }
        if (comentarioClasse != null && !comentarioClasse.isEmpty()) {
            retorno += comentarioClasse + "\n";
        }
        if (anotacoes != null && !anotacoes.isEmpty()) {
            retorno += StringUtils.join(anotacoes, "\n") + "\n";
        }
        if (acessibilidade != null) {
            retorno += Util.getString(acessibilidade.getValue()) + " ";
        }
        if (Boolean.TRUE.equals(objetoAbstrato)) {
            retorno += "abstract ";
        }
        if (Boolean.TRUE.equals(finalObject)) {
            retorno += "final ";
        }
        retorno += TipoObjetoEnum.CLASS.getValue() + " ";
        if (nome != null && !nome.isEmpty()) {
            retorno += Util.getString(nome) + " ";
        }
        if (maiorMenor != null && !maiorMenor.isEmpty()) {
            retorno += "<" + Util.getString(maiorMenor) + "> ";
        }
        if (!"".equals(Util.getString(objetoExtendido))) {
            retorno += "extends " + Util.getString(objetoExtendido) + " ";
        }
        if (objetosImplementados != null && !objetosImplementados.isEmpty()) {
            retorno += "implements " + StringUtils.join(objetosImplementados, ",") + " ";
        }

        retorno += "{\n\n";
        if (atributos != null && !atributos.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(atributos, "\n\n"), "\t") + "\n";
        }
        if (construtores != null && !construtores.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(construtores, "\n\n"), "\t") + "\n";
        }
        if (metodos != null && !metodos.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(metodos, "\n"), "\t") + "\n";
        }

        retorno += "}";
        return retorno;
    }
}
