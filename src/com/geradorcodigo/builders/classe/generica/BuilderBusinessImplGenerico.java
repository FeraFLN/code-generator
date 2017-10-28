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
import com.geradorcodigo.builders.padrao.outros.ConstrutorDefault;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.ClasseJava;
import com.geradorcodigo.domain.java.ConstrutorJava;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.templates.FactoryTemplate;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderBusinessImplGenerico extends AbstractBuilder<ClasseJava> {

    private Template templateBusinessImpl;
    private String nomeDominio;
    private String nomeClasse;

    public BuilderBusinessImplGenerico(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        this.templateBusinessImpl = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_BUSINESS_IMPL_GENERICO);
    }

    @Override
    public Template getTemplate() {
        return templateBusinessImpl;
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
            this.nomeClasse = nomeDominio + "BusinessImpl";
            ClasseJava businessImpl = builder2();
            businessImpl.setNome(nomeClasse);
           
            businessImpl.setAnotacoes(getAnotacoesClasse());
            Atributo atributoDao = getAtributoDao(nomeDominio);
            businessImpl.setAtributos(Arrays.asList(atributoDao));
            ConstrutorJava construtorJava = new ConstrutorDefault().getConstrutor(nomeClasse);
            construtorJava.setCorpo("super();");
            businessImpl.getConstrutores().add(construtorJava);
            businessImpl.getConstrutores().add(new ConstrutorDefault().getConstrutor(nomeClasse,atributoDao));
            
            
            businessImpl.setMetodos(getGenericDao(nomeDominio));
            //BusinessImpl.getMetodos().add(new MetodoSet().getMetodo(atributoSqlMap()));
            businessImpl.setPkg(getPkg());
            return businessImpl;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }

    private List<String> getAnotacoesClasse() throws GeradorException{
            List<String> retorno = new LinkedList<String>();
            for (String key : templateBusinessImpl.getMapTipos().keySet()) {
                retorno.add(templateBusinessImpl.getMapTipos().get(key));
            }
            return retorno;
    }
    
    private List<Metodo> getGenericDao(String nomeDominio) {
        Metodo mGet = new MetodoGet().getMetodo(getAtributoDao(nomeDominio));
        mGet.setNome("getSabiusDao");
        mGet.getAnotacoes().add("@Override");
        Metodo mSet = new MetodoSet().getMetodo(getAtributoDao(nomeDominio));
        mSet.getAnotacoes().add("@Override");
        mSet.setNome("setSabiusDao");
        return Arrays.asList(mGet,mSet);
    }
    private Atributo getAtributoDao(String nomeDominio) {
        List<String> anotations=Arrays.asList("@Autowired");
        return new Atributo(null, anotations, AcessibilidadeEnum.PRIVATE, Boolean.FALSE, Boolean.FALSE, nomeDominio+"Dao<" + nomeDominio + ">", StringUtils.uncapitalize(nomeDominio.concat("Dao")), null);
    }

    public static void main(String[] args) {
        try {
            BuilderBusinessImplGenerico b = new BuilderBusinessImplGenerico("UniUrgVeiculos", "Fernando Neto"," ");
            System.out.println(b.builder());
        } catch (GeradorException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getDetalhe());
        }

    }
}
