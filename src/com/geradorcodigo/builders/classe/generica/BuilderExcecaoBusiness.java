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
import com.geradorcodigo.domain.java.atributotipado.AtributoSerializabled;
import com.geradorcodigo.templates.FactoryTemplate;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderExcecaoBusiness extends AbstractBuilder<ClasseJava> {

    private Template templateBusinessImpl;
    private String nomeDominio;
//    private String nomeAutor;
    private String nomeClasse;

    public BuilderExcecaoBusiness(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        this.templateBusinessImpl = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_BUSINESS_EXCECAO);
    }

    @Override
    public Template getTemplate() {
        return templateBusinessImpl;
    }

    @Override
    protected void replacesClasseJava() throws GeradorException {
        getClasseJava().setComentarioClasse(getComentarioClasse().replace("[NOME_CLASSE]", nomeClasse).replace("[NOME_DOMAIN]", nomeDominio).replace("[NOME_AUTOR]", getNomeAutor()).replace("[DATA_CRIACAO]", getSdf().format(new Date())));

        String replace = getAssinaturaClasse().replace("[NOME_DOMAIN]", nomeDominio);
        setAssinaturaClasse(replace);
    }

    @Override
    public ClasseJava builder() throws BuilderGenericException {
        try {
            if(!(getObject() instanceof String)){
                throw new BuilderGenericException("Objeto informado de ser do tipo String.");
            }
            if ("".equals(Util.getString(getObject().toString()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe BusinessException.\nNome do domínio não informado.");
            }
            if ("".equals(Util.getString(getPkg()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe BusinessException.\nPackage não informada.");
            }
            if ("".equals(Util.getString(getNomeAutor()))) {
                throw new BuilderGenericException("Nome do autor tem preenchimento obrigatório.");
            }
//            this.nomeAutor = Util.getString(getNomeAutor());
            this.nomeDominio = getObject().toString();
            this.nomeClasse = nomeDominio + "BusinessException";
            ClasseJava businessImpl = builder2();
            businessImpl.setNome(nomeClasse);

            businessImpl.setAnotacoes(getAnotacoesClasse());
            businessImpl.setAtributos(Arrays.asList((Atributo) new AtributoSerializabled()));
            ConstrutorJava construtorJava = new ConstrutorDefault().getConstrutor(nomeClasse);
            construtorJava.setAtributos(Arrays.asList(new AtributoMetodo(Boolean.FALSE, "String", "mensagem")));
            construtorJava.setCorpo("super(mensagem);");
            businessImpl.getConstrutores().add(construtorJava);
            businessImpl.setPkg(getPkg());

            return businessImpl;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }

    private List<String> getAnotacoesClasse() throws GeradorException {
        List<String> retorno = new LinkedList<String>();
        for (String key : templateBusinessImpl.getMapTipos().keySet()) {
            retorno.add(templateBusinessImpl.getMapTipos().get(key));
        }
        return retorno;
    }

    public static void main(String[] args) {
        BigDecimal bigInteger = new BigDecimal(""+Math.pow(10, 125));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.pow(10, 125));
//        try {
//            
////            BuilderExcecaoBusiness b = new BuilderExcecaoBusiness("Unimeds", "Fernando Neto", "com.geradorcodigo.builders.generics.classe");
////            System.out.println(b.builder());
//        } catch (GeradorException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println(ex.getDetalhe());
//        }

    }
    public static int hex2decimal(String s) {
             String digits = "0123456789ABCDEF";
             s = s.toUpperCase();
             int val = 0;
             for (int i = 0; i < s.length(); i++) {
                 char c = s.charAt(i);
                 int d = digits.indexOf(c);
                 val = 16*val + d;
             }
             return val;
         }
}
