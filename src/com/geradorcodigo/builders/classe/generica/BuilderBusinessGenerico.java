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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderBusinessGenerico extends AbstractBuilder<InterfaceJava>{
    private Template templateBusiness ;
    private String nomeDominio;
    private String nomeAutor;
    private String nomeClasse;
    
    public BuilderBusinessGenerico(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        
        templateBusiness = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_BUSINESS_GENERICO);
    }

    @Override
    public InterfaceJava builder() throws BuilderGenericException {
        try {
            if(!(getObject() instanceof String)){
                throw new BuilderGenericException("Objeto informado de ser do tipo String.");
            }
            if ("".equals(Util.getString(getObject().toString()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe Business.\nNome do domínio não informado.");
            }
            if ("".equals(Util.getString(getPkg()))) {
                throw new BuilderGenericException("Erro ao tentar construir a classe Business.\nPackage não informada.");
            }
            if ("".equals(Util.getString(getNomeAutor()))) {
                throw new BuilderGenericException("Nome do autor tem preenchimento obrigatório.");
            }
            this.nomeAutor = Util.getString(getNomeAutor());
            this.nomeDominio = getObject().toString();
            this.nomeClasse = nomeDominio + "Business";
            InterfaceJava interfaceJava = builder2();
            interfaceJava.setNome(nomeClasse);
            interfaceJava.setAnotacoes(getAnotacoesClasse());
            interfaceJava.setPkg(getPkg());
            return interfaceJava;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }

    @Override
    protected void replacesClasseJava() throws GeradorException {
        getClasseJava().setComentarioClasse(getComentarioClasse().replace("[NOME_CLASSE]", nomeClasse).replace("[NOME_DOMAIN]", nomeDominio).replace("[NOME_AUTOR]", nomeAutor).replace("[DATA_CRIACAO]", getSdf().format(new Date())));
        String replace = getAssinaturaClasse().replace("[NOME_DOMAIN]", nomeDominio);
        setAssinaturaClasse(replace);
    }

    private List<String> getAnotacoesClasse() throws GeradorException{
            List<String> retorno = new LinkedList<String>();
            for (String key : templateBusiness.getMapTipos().keySet()) {
                retorno.add(templateBusiness.getMapTipos().get(key));
            }
            return retorno;
    }
    
    @Override
    public Template getTemplate() {
        return templateBusiness ;
    }
    protected static String getBranchName(String path) {
		if(!path.startsWith("/branches/") && path.contains("/branches/")){
			path = path.substring(path.indexOf("/branches/"));
		}
		if(path.startsWith("/branches/")){
			String branch = path.replaceFirst("/branches/", "");
			int pos = branch.indexOf("/");
			if(pos >= 0){
				return branch.substring(0, branch.indexOf("/"));
			} else {
				return branch;
			}
		}
		return "trunk";
	}
    public static void main(String[] args) {
        //String path = "/branches/BD_ARQ-764/sabius-financas-web/src/main/java/br/com/unimedfortaleza/sabius/financas/view/AdiarReajusteBean.java";
//        String path = "http://s00win42.unimedfortaleza.com.br/svn/financas/branches/BD_Testes/sabius-financas-web/src/main/java/br/com/unimedfortaleza/sabius/financas/view/AdiarReajusteBean.java";
//        System.out.println(getBranchName(path));
                try {
            BuilderBusinessGenerico b = new BuilderBusinessGenerico("Unimeds", "Fernando Neto", "com.geradorcodigo.builders.classe.generica");
            System.out.println(b.builder());
        } catch (GeradorException ex) {
            Logger.getLogger(BuilderDaoGenerico.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
