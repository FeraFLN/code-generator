/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.classe.generica;

import com.geradorcodigo.builders.exception.generica.BuilderGenericException;
import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.builders.AbstractBuilder;
import com.geradorcodigo.builders.padrao.BuilderMetodoDefault;
import com.geradorcodigo.business.banco.ColunaBusiness;
import com.geradorcodigo.business.banco.ColunaBusinessImpl;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.banco.Tabela;
import com.geradorcodigo.domain.java.ClasseJava;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.templates.FactoryTemplate;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.templates.properties.TemplateDomainGenericoProp;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderDomainGenerico extends AbstractBuilder<ClasseJava> {

    private ColunaBusiness colunaBusiness;
    private Template templateDomain;
    private ClasseJava classeJava;
    private String nomeTabela = "";
    private String nomeAutor = "";
    private List<Coluna> colunas;
    private List<Coluna> colunasClone;
    private final String corpoClone = "try {\n"
            + "   return ([DOMAIN]) super.clone();\n"
            + "} catch (CloneNotSupportedException ex) {\n"
            + "   Logger.getLogger(UniurgVeiculos.class.getName()).log(Level.SEVERE, null, ex);\n"
            + "}\n"
            + "return null;";
    private String colunaDescricao = "";
    private String idColuna = "";

    public BuilderDomainGenerico(Object o, String nomeAutor, String pkg) throws GeradorException {
        super(o, nomeAutor, pkg);
        this.templateDomain = (TemplateDomainGenericoProp) FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_DOMAIN_GENERICO);
        this.colunaBusiness = new ColunaBusinessImpl();
    }

    @Override
    public Template getTemplate() {
        return templateDomain;
    }

    @Override
    protected void replacesClasseJava() throws GeradorException {
        getClasseJava().setComentarioClasse(getComentarioClasse().replace("[NOME_CLASSE]", Util.converteNomeTabelaToClasse(nomeTabela)).replace("[NOME_TABELA]", nomeTabela).replace("[NOME_AUTOR]", nomeAutor).replace("[DATA_CRIACAO]", getSdf().format(new Date())).replace("[COLUNAS_TABELA]", Util.tabLineString(StringUtils.join(colunas, "\n"), " *\t\t").trim()));
    }

    public List<Coluna> getColunas() {
        return colunasClone;
    }

    public void setIdDescEntity(String id,String colunaDescricao) {
        this.colunaDescricao = colunaDescricao;
        this.idColuna = id;
    }

    @Override
    public ClasseJava builder() throws BuilderGenericException {
        try {
            if (!(getObject() instanceof Tabela)) {
                throw new BuilderGenericException("Objeto informado de ser do tipo Tabela.");
            }
            if ("".equals(Util.getString(getNomeAutor()))) {
                throw new BuilderGenericException("Nome do autor tem preenchimento obrigatório.");
            }
            if ("".equals(Util.getString(getPkg()))) {
                throw new BuilderGenericException("Package tem preenchimento obrigatório.");
            }
            Tabela tabela = (Tabela) getObject();
            colunas = colunaBusiness.select(tabela);
            colunasClone = new ArrayList<Coluna>(colunas);
            nomeTabela = tabela.getNome();

            this.nomeAutor = getNomeAutor();
            classeJava = builder2();
            classeJava.setNome(Util.converteNomeTabelaToClasse(nomeTabela));
            classeJava.setPkg(getPkg());
            classeJava.getAnotacoes().add("@MessageEntity");
            classeJava.getAnotacoes().add("@DuplicateKeyErrorMessage(message=\"[NOME_MODULO] já cadastrado.\")");
            classeJava.setAtributos(new BuilderAtributoDomainGenerico().builderAtributos(colunas,
                    templateDomain.getComentarioAtributos(),
                    templateDomain.getMapTipos(),colunaDescricao,idColuna));
            classeJava.setMetodos(new BuilderMetodoDefault(classeJava.getAtributos()).builderGetsSets().builderHashCode().builderEquals(classeJava.getNome()).build());
            criarMetodoClone();
            return classeJava;
        } catch (GeradorException ex) {
            throw new BuilderGenericException(ex.getMessage(), ex.getDetalhe());
        }
    }
    

    private void criarMetodoClone() {
        Metodo metodo = new Metodo();
        metodo.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        metodo.setAnotacoes(Arrays.asList("@Override"));
        metodo.setCorpo(corpoClone.replace("[DOMAIN]", classeJava.getNome()));
        metodo.setNome("clone");
        metodo.setRetorno("Object");
        classeJava.getMetodos().add(metodo);

    }

    public static void main(String[] args) {
        try {
            BuilderDomainGenerico d = new BuilderDomainGenerico(new Tabela("SABIUS", "unimeds", null), "FERNANDO NETO", "com.geradorcodigo.builders.generics");
            ClasseJava cj = d.builder();
            System.out.println(cj.toString());
        } catch (GeradorException ex) {
            System.out.println(ex.getMessage() + "    " + ex.getDetalhe());
        }
    }
}
