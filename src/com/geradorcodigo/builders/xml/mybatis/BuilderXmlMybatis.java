/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.xml.mybatis;

import com.geradorcodigo.builders.classe.generica.BuilderDomainGenerico;
import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.builders.xml.mybatis.exception.XmlMybatisException;
import com.geradorcodigo.builders.xml.mybatis.util.XmlMybatisUtil;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.banco.Tabela;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.ClasseJava;
import com.geradorcodigo.domain.java.atributotipado.AtributoDominioGenerico;
import com.geradorcodigo.templates.FactoryTemplate;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import com.geradorxml.mybatis.Delete;
import com.geradorxml.mybatis.Id;
import com.geradorxml.mybatis.Include;
import com.geradorxml.mybatis.Insert;
import com.geradorxml.mybatis.Mapper;
import com.geradorxml.mybatis.Result;
import com.geradorxml.mybatis.ResultMap;

import com.geradorxml.mybatis.Select;
import com.geradorxml.mybatis.Sql;
import com.geradorxml.mybatis.Update;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.hibernate.jdbc.util.BasicFormatterImpl;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderXmlMybatis {

    private final String ID_COLUMN_SQL = "colunasSql";
    private final String ID_WHERE_SQL = "whereSql";
    private final String ID_WHERE_PAGINADA_SQL = "whereSqlPaginada";
    private final String ID_TABELA = "[TABELA]";
    private final String ID_COLUNA = "[COLUNA]";
    private final String ID_INCLUDE_INSERT = "[INCLUDE]";
    private final String insert = "INSERT INTO "+ID_TABELA+"(<include refid=\""+ID_INCLUDE_INSERT+"\"/>) VALUES ("+ID_COLUNA+")";
    private Mapper mapper;
    private Template templateDomian;
    private List<Coluna> colunas;
    private ClasseJava dominio;
    private List<Object> mapperListObjects;
    private String idResultMap;
    private String type;
    private String nomeTabela;
    private String nomeEsquema;
    private final BasicFormatterImpl formatterImpl = new BasicFormatterImpl(); 
    private final String oldHead = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>";
    private final String newHead = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>\n"
            + "<!DOCTYPE mapper\n"
            + "     PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n"
            + "            \"http://localhost:8085/dtd/mybatis-3-config.dtd\">  ";

    public BuilderXmlMybatis(List<Coluna> colunas, ClasseJava dominio, String nameSpace) throws GeradorException {
        mapper = new Mapper();
        mapperListObjects = mapper.getCacheRefOrCacheOrResultMapOrParameterMapOrSqlOrInsertOrUpdateOrDeleteOrSelect();
        templateDomian = FactoryTemplate.getTemplate(FactoryTemplate.TEMPLATE_DOMAIN_GENERICO);
        mapper.setNamespace(nameSpace);
        this.colunas = colunas;
        this.dominio = dominio;
        this.idResultMap = dominio.getNome() + "ResultMap";
        this.type = dominio.getNome();
        if (colunas != null && !colunas.isEmpty()) {
            nomeTabela = colunas.get(0).getTabela().getNome();
            nomeEsquema = colunas.get(0).getTabela().getOwner();
        }

    }

    public Mapper build() {
        return mapper;
    }

    public BuilderXmlMybatis getUpdate() throws GeradorException {
        Update u = new Update();
        u.setId("altera".concat(dominio.getNome()));
        u.setParameterType(type);
        List<Coluna> ids = XmlMybatisUtil.idColunasSql(colunas);
        String where = "";
        if (!ids.isEmpty()) {
            where = "\nwhere ".concat(XmlMybatisUtil.buildCondicaoSql(ids));
        } else {
            throw new XmlMybatisException("Não foi possível encontrar os ids para criar o delete.");
        }
        String updateString = "update ".concat(nomeEsquema + "." + nomeTabela).concat("\nset ").concat(XmlMybatisUtil.buildSetUpdateSql(colunas)).concat(where);
        updateString = formatterImpl.format(updateString);
        u.setvalue(Util.tabLineString(updateString, "\t"));
        mapperListObjects.add(u);
        return this;

    }

    public ClasseJava getDominio() {
        return dominio;
    }

    public BuilderXmlMybatis getDelete() throws GeradorException {
        Delete d = new Delete();
        d.setParameterType(type);
        d.setId("exclui".concat(dominio.getNome()));
        List<Coluna> ids = XmlMybatisUtil.idColunasSql(colunas);
        String where = "";
        if (!ids.isEmpty()) {
            where = " where ".concat(XmlMybatisUtil.buildCondicaoSql(ids));
        } else {
            throw new XmlMybatisException("Não foi possível encontrar os ids para criar o delete.");
        }
        String sql = "delete from ".concat(nomeEsquema + "." + nomeTabela).concat(where);
        sql = formatterImpl.format(sql);
        d.setvalue(Util.tabLineString(sql, "\t"));
        mapperListObjects.add(d);
        return this;
    }

    public BuilderXmlMybatis getInsert() throws GeradorException {
        Insert i = new Insert();
        i.setId("inclui".concat(dominio.getNome()));
        i.setParameterType(type);
        getSqlColumn(ID_COLUMN_SQL);
        Include includeColuna = new Include();
        includeColuna.setRefid(ID_COLUMN_SQL);
        String sql = insert.replace(ID_TABELA,nomeEsquema + "." + nomeTabela)
                .replace(ID_COLUNA, XmlMybatisUtil.buildTagSql(colunas))
                .replace(ID_INCLUDE_INSERT, ID_COLUMN_SQL);
        sql = formatterImpl.format(sql);
        i.getValue().add(Util.tabLineString(sql, "\t"));
//        i.getValue().add(includeColuna);
//        sql =")".concat(" VALUES (").concat(XmlMybatisUtil.buildTagSql(colunas)).concat(")");
//        sql = formatterImpl.format(sql);
//        i.getValue().add(Util.tabLineString(sql, "\t"));
        mapperListObjects.add(i);
        return this;

    }

    public BuilderXmlMybatis getResultMap() throws GeradorException {
        ResultMap resultMap = new ResultMap();
        resultMap.setIdResult(getIdResultMap());
        resultMap.setType(dominio.getNome());
        getId(resultMap, colunas, dominio);
        getResult(resultMap, colunas, dominio);
        mapperListObjects.add(resultMap);
        return this;
    }

    private String getIdResultMap() {
        return idResultMap;
    }

    public BuilderXmlMybatis getSelectAutoComplete(String nomeColunaId, String nomeColunaDescicao) throws GeradorException {
        SelectGenericsXmlMybatis sgxm = new SelectGenericsXmlMybatis(colunas.get(0).getTabela().getNome(), colunas);
        Select s = sgxm.getSelectAutoComplete(nomeColunaId, nomeColunaDescicao, idResultMap, type);
        mapperListObjects.add(s);
        return this;
    }

    public BuilderXmlMybatis getSelectFindBykey(String nomeColunaId, String nomeColunaDescicao) throws GeradorException {
        SelectGenericsXmlMybatis sgxm = new SelectGenericsXmlMybatis(colunas.get(0).getTabela().getNome(), colunas);
        Select s = sgxm.getSelectFindbyKey(nomeColunaId, nomeColunaDescicao, idResultMap, type);
        mapperListObjects.add(s);
        return this;
    }

    public BuilderXmlMybatis getSelectPaginated() throws GeradorException {
        getSqlColumn(ID_COLUMN_SQL);
        Include includeColuna = new Include();
        includeColuna.setRefid(ID_COLUMN_SQL);
        getSqlWherePaginada();
        Include includeWhere = new Include();
        includeWhere.setRefid(ID_WHERE_PAGINADA_SQL);
        SelectGenericsXmlMybatis sgxm = new SelectGenericsXmlMybatis(colunas.get(0).getTabela().getNome(), colunas);
        Select s = sgxm.getSelectPaginated(includeColuna, includeWhere, idResultMap, type);
        mapperListObjects.add(s);
        mapperListObjects.add(sgxm.getSelectPaginatedCount(includeWhere, idResultMap, type));
        return this;
    }

    public BuilderXmlMybatis getSelect() throws GeradorException {
        getSqlColumn(ID_COLUMN_SQL);
        Include includeColuna = new Include();
        includeColuna.setRefid(ID_COLUMN_SQL);
        getSqlWhere();
        Include includeWhere = new Include();
        includeWhere.setRefid(ID_WHERE_SQL);
        SelectGenericsXmlMybatis sgxm = new SelectGenericsXmlMybatis(colunas.get(0).getTabela().getNome(), colunas);
        Select s = sgxm.getSelect(includeColuna, includeWhere, idResultMap, type);
        mapperListObjects.add(s);
        return this;
    }

    private void getSqlWherePaginada() throws GeradorException {
        Sql sql = new SqlXmlMybatis(colunas).getWhereSqlWithIf(ID_WHERE_PAGINADA_SQL, "object.");
        if (!mapperListObjects.contains(sql)) {
            mapperListObjects.add(sql);
        }
    }

    private void getSqlWhere() throws GeradorException {
        Sql sql = new SqlXmlMybatis(colunas).getWhereSqlWithIf(ID_WHERE_SQL, "");
        if (!mapperListObjects.contains(sql)) {
            mapperListObjects.add(sql);
        }
    }

    private void getSqlColumn(String id) {
        Sql sqlXmlMybatis = new SqlXmlMybatis(colunas).getSqlColumn(id);
        if (!mapperListObjects.contains(sqlXmlMybatis)) {
            mapperListObjects.add(sqlXmlMybatis);
        }
    }

    private void getResult(ResultMap resultMap, List<Coluna> colunas, ClasseJava dominio) throws GeradorException {
        for (Coluna coluna : colunas) {
            if (isValidoColunaAtributo(coluna, dominio) && !coluna.getPrimaryKey()) {
                Result result = new Result();
                result.setColumn(coluna.getNome());
                result.setProperty(XmlMybatisUtil.getProperty(coluna));
                resultMap.getResult().add(result);
            }
        }
    }

    private void getId(ResultMap resultMap, List<Coluna> colunas, ClasseJava dominio) throws GeradorException {
        for (Coluna coluna : colunas) {
            if (isValidoColunaAtributo(coluna, dominio) && coluna.getPrimaryKey()) {
                Id id = new Id();
                id.setColumn(coluna.getNome());
                id.setProperty(XmlMybatisUtil.getProperty(coluna));
                resultMap.getId().add(id);
            }
        }

    }

    /**
     * Verifica se a coluna tem chave estrangeira, caso seja verdade ele pega o 
     * nome da tabela referencia, converte para nome de classe, cria um atributo de 
     * classe com o tipo e o nome do atributo sendo o mesmo nome da tabela e depois 
     * verifica se existe esse atributo no dominio informado como paramentro da 
     * classe. Exemplo: A coluna id_escolar da tabela material_escolar
     * faz join com a tabela escola, então eu crio um atributo, 
     * "private Escola escola;" e verifico se o paramentro informado "dominio" 
     * contém esse atributo, caso seja verdade, então ele retorna true; 
     * caso seja falso retorne false;
     * 
     * @param coluna
     * @param dominio
     * @return
     * @throws GeradorException 
     */
    private boolean isValidoColunaAtributo(Coluna coluna, ClasseJava dominio) throws GeradorException {
        Atributo converteAtributo;
        if (dominio == null) {
            throw new XmlMybatisException("Dominio nullo ou vazio.");
        }
        if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {

            converteAtributo = new AtributoDominioGenerico(coluna, null, templateDomian.getMapTipos(), "", "");
            converteAtributo.setNome(Util.converteNomeColunaToAtri(coluna.getForengkey().getTabelaReferenciada()));
            converteAtributo.setTipo(Util.converteNomeTabelaToClasse(coluna.getForengkey().getTabelaReferenciada()));
        } else {
            converteAtributo = new AtributoDominioGenerico(coluna, null, templateDomian.getMapTipos(), "", "");
        }
        if (dominio.getAtributos() == null) {
            return false;
        }
        return dominio.getAtributos().contains(converteAtributo);

    }

    public String marshall() throws GeradorException {
        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(Mapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
            m.marshal(mapper, writer);
            String xml = writer.toString().replace(oldHead, newHead).replace("&lt;", "<").replace("&gt;", ">");
            return xml;//solução alternativa para o JABX 1.0
        } catch (JAXBException ex) {
            throw new GeradorException("Erro ao tentar criar o xml.", ex.getMessage());
        }
    }

    
    
    
    
    //    @Override
    //    public String toString(){
    //        return marshall();
    //    }
    //
        public static void main(String[] args) {
            try {
    
                BuilderDomainGenerico d = new BuilderDomainGenerico(new Tabela("sabius", "uniurg_veiculos", null), "Fernando", "br.com.geradorcodigoteste.dao");
                ClasseJava builder = d.builder();
                BuilderXmlMybatis b = new BuilderXmlMybatis(d.getColunas(), builder, builder.getPkg());
    //            teste2(b.getMapper());
                b.getResultMap()
                        .getSelectPaginated()
                        .getSelectFindBykey("COD_VEICULO", "NOME_VEICULO")
                        .getSelectAutoComplete("COD_VEICULO", "NOME_VEICULO")
                        .getInsert()
                        .getDelete()
                        .getUpdate()
                        .build();
                System.out.println(b.marshall());
            } catch (GeradorException ex) {
                Logger.getLogger(BuilderXmlMybatis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//    @Override
//    public String toString(){
//        return marshall();
//    }
//
//    public static void main(String[] args) {
//        try {
//
//            BuilderDomainGenerico d = new BuilderDomainGenerico();
//            ClasseJava builder = d.builder(new Tabela("sabius", "UNIMEDS", null), "Fernando", "br.com.geradorcodigoteste.dao");
//            BuilderXmlMybatis b = new BuilderXmlMybatis(d.getColunas(), builder, builder.getPkg());
////            teste2(b.getMapper());
//            System.out.println(teste(b.getResultMap()
//                    .getSelectPaginated()
//                    .getSelectFindBykey("COD_UNIMED", "NOME_ABREV")
//                    .getSelectAutoComplete("COD_UNIMED", "NOME_ABREV")
//                    .getInsert()
//                    .getDelete()
//                    .getUpdate()
//                    .build()));
//        } catch (JAXBException ex) {
//            Logger.getLogger(BuilderXmlMybatis.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (GeradorException ex) {
//            Logger.getLogger(BuilderXmlMybatis.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
