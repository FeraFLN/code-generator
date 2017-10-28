/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.classe.generica;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.builders.AbstractBuilder;
import com.geradorcodigo.builders.exception.generica.BuilderGenericException;
import com.geradorcodigo.builders.padrao.getset.MetodoGet;
import com.geradorcodigo.builders.padrao.getset.MetodoSet;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.ClasseJava;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.templates.FactoryTemplate;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderBeanGenerico extends AbstractBuilder<ClasseJava> {

    private Template templateBean;
    private String nomeDominio;
    private String nomeClasse;

    public BuilderBeanGenerico(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        this.templateBean = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_BEAN_GENERICO);
    }

    @Override
    public Template getTemplate() {
        return templateBean;
    }

    @Override
    protected void replacesClasseJava() throws GeradorException {
        getClasseJava().setComentarioClasse(getComentarioClasse().replace("[NOME_CLASSE]", nomeClasse).replace("[NOME_DOMAIN]", nomeDominio).replace("[NOME_AUTOR]", getNomeAutor()).replace("[DATA_CRIACAO]", getSdf().format(new Date())));

        String replace = getAssinaturaClasse().replace("[NOME_DOMAIN]", nomeDominio).replace("[NOME_CLASSE]", nomeClasse);
        setAssinaturaClasse(replace);
    }

    @Override
    public ClasseJava builder() throws BuilderGenericException {
        try {
            if(!(getObject() instanceof String)){
                throw new BuilderGenericException("Objeto informado de ser do tipo String.");
            }
            if ("".equals(Util.getString(getObject().toString()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe BusinessImpl.\nNome do domínio não informado.");
            }
            if ("".equals(Util.getString(getPkg()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe BusinessImpl.\nPackage não informada.");
            }
            if ("".equals(Util.getString(getNomeAutor()))) {
                throw new BuilderGenericException("Nome do autor tem preenchimento obrigatório.");
            }
            this.nomeDominio = getObject().toString();
            this.nomeClasse = nomeDominio + "Bean";
            ClasseJava bean = builder2();
            bean.setNome(nomeClasse);
            bean.setAnotacoes(getAnotacoesClasse());
            Atributo atributoDao = getAtributoBusiness(nomeDominio);
            bean.setAtributos(Arrays.asList(atributoDao));
            bean.setMetodos(getGenericBusiness(nomeDominio));
            bean.getMetodos().add(getOtherInstances());
            bean.getMetodos().add(getEntidadeInstances());
            bean.setPkg(getPkg());
            return bean;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }

    private List<String> getAnotacoesClasse() throws GeradorException{
            List<String> retorno = new LinkedList<String>();
            for (String key : templateBean.getMapTipos().keySet()) {
                retorno.add(templateBean.getMapTipos().get(key));
            }
            return retorno;
    }
    
    private Metodo getOtherInstances(){
        Metodo metodo = new Metodo();
        metodo.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        metodo.setAnotacoes(Arrays.asList("@Override"));
        metodo.setNome("otherInstances");
        metodo.setCorpo("//TODO-Instanciar objetos necessarios na inicialização da tela.");
        return metodo;
    }
    private Metodo getEntidadeInstances(){
        Metodo metodo = new Metodo();
        metodo.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        metodo.setAnotacoes(Arrays.asList("@Override"));
        metodo.setNome("entidadeInstances");
        metodo.setCorpo("//TODO-Instanciar os tributos necessarios para o formulario.");
        return metodo;
    }
    
    private List<Metodo> getGenericBusiness(String nomeDominio) {
        Metodo mGet = new MetodoGet().getMetodo(getAtributoBusiness(nomeDominio));
        mGet.setNome("getSabiusBusiness");
        mGet.getAnotacoes().add("@Override");
        Metodo mSet = new MetodoSet().getMetodo(getAtributoBusiness(nomeDominio));
        mSet.getAnotacoes().add("@Override");
        mSet.setNome("setSabiusBusiness");
        return new ArrayList<Metodo>(Arrays.asList(mGet,mSet));
    }
    private Atributo getAtributoBusiness(String nomeDominio) {
        List<String> anotations=Arrays.asList("@Autowired");
        return new Atributo(null, anotations, AcessibilidadeEnum.PRIVATE, Boolean.FALSE, Boolean.FALSE, nomeDominio+"Business", StringUtils.uncapitalize(nomeDominio)+"Business", null);
    }

    public static void main(String[] args) {
        try {
            BuilderBeanGenerico b = new BuilderBeanGenerico("AcoesUnimed", "Fernando Neto", "com.geradorcodigo.builders.generics.classe");
            System.out.println(b.builder());
        } catch (GeradorException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getDetalhe());
        }

    }
}
