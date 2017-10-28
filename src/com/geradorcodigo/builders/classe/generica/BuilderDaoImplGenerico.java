/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.classe.generica;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.builders.AbstractBuilder;
import com.geradorcodigo.builders.exception.generica.BuilderGenericException;
import com.geradorcodigo.builders.padrao.outros.ConstrutorDefault;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.AtributoMetodo;
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

/**
 *
 * @author T01BRQ0067
 */
public class BuilderDaoImplGenerico extends AbstractBuilder<ClasseJava> {

    private Template templateDaoImpl;
    private String nomeDominio;
    private String nomeAutor;
    private String nomeClasse;

    public BuilderDaoImplGenerico(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        this.templateDaoImpl = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_DAOIMPL_GENERICO);
    }

    @Override
    public Template getTemplate() {
        return templateDaoImpl;
    }

    @Override
    protected void replacesClasseJava() throws GeradorException {
        getClasseJava().setComentarioClasse(getComentarioClasse().replace("[NOME_CLASSE]", nomeClasse).replace("[NOME_DOMAIN]", nomeDominio).replace("[NOME_AUTOR]", nomeAutor).replace("[DATA_CRIACAO]", getSdf().format(new Date())));

        String replace = getAssinaturaClasse().replace("[NOME_DOMAIN]", nomeDominio);
        setAssinaturaClasse(replace);
    }

    @Override
    public ClasseJava builder() throws BuilderGenericException {
        try {
            if (!(getObject() instanceof String)) {
                throw new BuilderGenericException("Objeto informado de ser do tipo String.");
            }
            if ("".equals(Util.getString(getObject().toString()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe daoimpl.\nNome do domínio não informado.");
            }
            if ("".equals(Util.getString(getPkg()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe daoimpl.\nPackage não informada.");
            }
            if ("".equals(Util.getString(getNomeAutor()))) {
                throw new BuilderGenericException("Nome do autor tem preenchimento obrigatório.");
            }
            this.nomeAutor = Util.getString(getNomeAutor());
            this.nomeDominio = getObject().toString();
            this.nomeClasse = nomeDominio + "DaoImpl";
            ClasseJava daoImpl = builder2();
            daoImpl.setNome(nomeClasse);
            daoImpl.setAnotacoes(Arrays.asList("@Component"));
            ConstrutorJava c = new ConstrutorDefault().getConstrutor(nomeClasse);
            c.setCorpo("super();");
            daoImpl.setConstrutores(Arrays.asList(c));
            daoImpl.setAnotacoes(getAnotacoesClasse());
            daoImpl.setPkg(getPkg());
            daoImpl.setMetodos(Arrays.asList(getMetodoSessionTemplate()));
            return daoImpl;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }
//    private List<Metodo> getGenericDao(String nomeDominio) {
//        Metodo mGet = new MetodoGet().getMetodo(getAtributoDao(nomeDominio));
//        mGet.setNome("getSabiusDao");
//        mGet.getAnotacoes().add("@Override");
//        Metodo mSet = new MetodoSet().getMetodo(getAtributoDao(nomeDominio));
//        mSet.getAnotacoes().add("@Override");
//        mSet.setNome("setSabiusDao");
//        return Arrays.asList(mGet,mSet);
//    }

    private Metodo getMetodoSessionTemplate() {
        Metodo m = new Metodo();
        m.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        m.setComentario("//TODO-Adicionar o factory do context-bean no @Qualifier,\n//ex: sqlSessionTemplateComercial,sqlSessionTemplateFinancas,sqlSessionTemplateServicosAssistenciais");
        m.setAnotacoes(Arrays.asList("@Autowired", "@Override", "@Qualifier(\"[ALTERAR]\")"));
        m.setNome("setSessionTemplate");
        m.setAtributos(Arrays.asList(new AtributoMetodo(Boolean.FALSE, "SqlSessionTemplate", "sessionTemplate")));
        m.setCorpo("super.setSqlSessionTemplate(sessionTemplate);");
        return m;
    }

    private List<String> getAnotacoesClasse() throws GeradorException {
        List<String> retorno = new LinkedList<String>();
        for (String key : templateDaoImpl.getMapTipos().keySet()) {
            retorno.add(templateDaoImpl.getMapTipos().get(key));
        }
        return retorno;
    }

    public static void main(String[] args) {
        try {

            BuilderDaoImplGenerico b = new BuilderDaoImplGenerico("Unimeds", "Fernando Neto", "com.geradorcodigo.builders.generics.classe");
            System.out.println(b.builder());
        } catch (GeradorException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getDetalhe());
        }

    }
}
