/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.classe.generica;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.builders.AbstractBuilder;
import com.geradorcodigo.builders.exception.generica.BuilderGenericException;
import com.geradorcodigo.domain.java.InterfaceJava;
import com.geradorcodigo.templates.FactoryTemplate;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderDaoGenerico extends AbstractBuilder<InterfaceJava> {

    private Template templateDao ;
    private String nomeDominio;
    private String nomeAutor;
    private String nomeClasse;

    public BuilderDaoGenerico(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        templateDao = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_DAO_GENERICO);
    }

    @Override
    public InterfaceJava builder() throws BuilderGenericException {
        try {
            if(!(getObject() instanceof String)){
                throw new BuilderGenericException("Objeto informado de ser do tipo String.");
            }
            if ("".equals(Util.getString(getObject().toString()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe Dao.\nNome do domínio não informado.");
            }
            if ("".equals(Util.getString(getPkg()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe Dao.\nPackage não informada.");
            }
            if ("".equals(Util.getString(getNomeAutor()))) {
                throw new BuilderGenericException("Nome do autor tem preenchimento obrigatório.");
            }
            this.nomeAutor = Util.getString(nomeAutor);
            this.nomeDominio = getObject().toString();
            this.nomeClasse = nomeDominio + "Dao";
            InterfaceJava classeJava = builder2();
            classeJava.setNome(nomeClasse);
            classeJava.setPkg(getPkg());
            return classeJava;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }

    @Override
    protected void replacesClasseJava() throws GeradorException {
        getClasseJava().setComentarioClasse(getComentarioClasse().replace("[NOME_CLASSE]", nomeClasse).replace("[NOME_DOMAIN]", nomeDominio).replace("[NOME_AUTOR]", getNomeAutor()).replace("[DATA_CRIACAO]", getSdf().format(new Date())));
    }

    @Override
    public Template getTemplate() {
        return templateDao ;
    }
    public static void main(String[] args) {
        try {
            BuilderDaoGenerico b = new BuilderDaoGenerico("Unimeds", "Fernando Neto", "com.geradorcodigo.builders.classe.generica");
            System.out.println(b.builder());
        } catch (GeradorException ex) {
            Logger.getLogger(BuilderDaoGenerico.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
