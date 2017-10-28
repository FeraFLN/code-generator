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
public class InterfaceJava implements ObjetoJava{
    private String comentarioInicial;
    private String pkg;
    private List<String> importacoes;
    private String comentarioClasse;
    private List<String> anotacoes;
    private AcessibilidadeEnum acessibilidade;
    private Boolean objetoAbstrato;
    private String nome;
    private String maiorMenor;
    private String objetoExtendido;
    private List<AssinaturaMetodo> assinaturaMetodos;

    public InterfaceJava() {
    }

    public InterfaceJava(String comentarioInicial, String pkg, List<String> importacoes, String comentarioClasse, List<String> anotacoes, AcessibilidadeEnum acessibilidade, Boolean objetoAbstrato, String nome, String maiorMenor, String objetoExtendido, List<AssinaturaMetodo> assinaturaMetodos) {
        this.comentarioInicial = comentarioInicial;
        this.pkg = pkg;
        this.importacoes = importacoes;
        this.comentarioClasse = comentarioClasse;
        this.anotacoes = anotacoes;
        this.acessibilidade = acessibilidade;
        this.objetoAbstrato = objetoAbstrato;
        this.nome = nome;
        this.maiorMenor = maiorMenor;
        this.objetoExtendido = objetoExtendido;
        this.assinaturaMetodos = assinaturaMetodos;
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

    public List<AssinaturaMetodo> getAssinaturaMetodos() {
        return assinaturaMetodos;
    }

    public void setAssinaturaMetodos(List<AssinaturaMetodo> assinaturaMetodos) {
        this.assinaturaMetodos = assinaturaMetodos;
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

    @Override
    public void setComentarioInicial(String comentarioInicial) {
        this.comentarioInicial = comentarioInicial;
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

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
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
        retorno += TipoObjetoEnum.INTERFACE.getValue() + " ";
        if (nome != null && !nome.isEmpty()) {
            retorno += Util.getString(nome) + " ";
        }
        if (maiorMenor != null && !maiorMenor.isEmpty()) {
            retorno += "<" + Util.getString(maiorMenor) + "> ";
        }
        if (!"".equals(Util.getString(objetoExtendido))) {
            retorno += "extends " + Util.getString(objetoExtendido) + " ";
        }
        
        retorno += "{\n\n";
        if (assinaturaMetodos != null && !assinaturaMetodos.isEmpty()) {
            retorno += Util.tabLineString(StringUtils.join(assinaturaMetodos, "\n"), "\t") + "\n";
        }

        retorno += "}";
        return retorno;
    }

    @Override
    public void setObjetosImplementados(List<String> implementados) {
        //TODO: INTERFACE NÃO IMPLEMENTA
    }
}
