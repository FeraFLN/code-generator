/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.AtributoMetodo;
import com.geradorcodigo.domain.java.ConstrutorJava;
import com.geradorcodigo.domain.java.EnumJava;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;

/**
 *
 * @author T01BRQ0067
 */
public class TesteEnumJava extends TestCase {
    private EnumJava enumJava;
    public TesteEnumJava(String testName) {
        super(testName);
        enumJava = new EnumJava("/*teste enum java comentario inicial*/",
                                "br.teste.enum", 
                                Arrays.asList("import main.java.com.geradorcodigo.domain.Atributo;",
                                                "import main.java.com.geradorcodigo.domain.AtributoMetodo;",
                                                "import main.java.com.geradorcodigo.domain.JavaObjeto;"), 
                                 "/*teste enum java comentario classe*/", 
                                 Arrays.asList("@Transactionrollback", "@TesteUnitario"), 
                                  "TesteEnum", 
                                 Arrays.asList("TESTE1", "TESTE2"), 
                                getListAtributos(),
                                getMetodo(),
                                getConstrutorJavas());
    }
    
    private List<ConstrutorJava> getConstrutorJavas(){
        List<ConstrutorJava> l = new ArrayList<ConstrutorJava>();
        List<AtributoMetodo> l1 = Arrays.asList(new AtributoMetodo(Boolean.FALSE, "String", "teste"),
                new AtributoMetodo(Boolean.FALSE, "String", "teste1"));
        ConstrutorJava c = new ConstrutorJava("/*comentario construtor*/", 
                                              Arrays.asList("@Teste"), 
                                              AcessibilidadeEnum.PRIVATE, 
                                              "T",
                                              "TesteEnum", 
                                              l1, 
                                              "this.teste=teste;");
        l.add(c);
        c=new ConstrutorJava("TesteEnum");
        c.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        l.add(c);
        return l;
    }

       private List<Atributo> getListAtributos() {
        List<Atributo> list = new ArrayList<Atributo>();
        Atributo a = new Atributo();
        a.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        a.setAnotacoes(Arrays.asList("@Teste", "@Unitario"));
        a.setAtributoFinal(Boolean.TRUE);
        a.setComentario("/*Atributo 1*/");
        a.setNome("atributo1");
        a.setStatico(Boolean.TRUE);
        a.setTipo("String");
        a.setValor("\"atreibuto valor\"");
        list.add(a);

        a = new Atributo();
        a.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        a.setAnotacoes(Arrays.asList("@Teste", "@Unitario"));
        a.setAtributoFinal(Boolean.TRUE);
        a.setComentario("/*Atributo 2*/");
        a.setNome("atributo2");
        a.setStatico(Boolean.TRUE);
        a.setTipo("Integer");
        a.setValor("1");
        list.add(a);
        a = new Atributo();
        a.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        a.setAnotacoes(Arrays.asList("@Teste", "@Unitario"));
        a.setAtributoFinal(Boolean.TRUE);
        a.setComentario("/*Atributo 3*/");
        a.setNome("atributo3");
        a.setStatico(Boolean.TRUE);
        a.setTipo("Boolean");
        a.setValor("true");
        list.add(a);
        return list;
    }
     private List<Metodo> getMetodo() {
        List<AtributoMetodo> l = Arrays.asList(new AtributoMetodo(Boolean.FALSE, "String", "teste"),
                new AtributoMetodo(Boolean.FALSE, "String", "teste1"));
        List<String> a = Arrays.asList("@Teste", "@String");
        List<Metodo> list = new ArrayList<Metodo>();
        Metodo metodo = new Metodo("/**\n*Teste unitário metodo\n*/",
                a,
                AcessibilidadeEnum.PUBLIC,
                Boolean.TRUE, Boolean.TRUE,
                "T", "String", "getTeste",
                l, "System.out.println(\"teste unitário\");\nreturn \"deu certo\";",
                Boolean.FALSE);
        list.add(metodo);
        metodo = new Metodo("/**\n*Teste unitário metodo2\n*/",
                a,
                AcessibilidadeEnum.PUBLIC,
                Boolean.TRUE, Boolean.TRUE,
                "T", "String", "getTeste2",
                l, "System.out.println(\"teste unitário\");\nreturn \"deu certo\";",
                Boolean.FALSE);
        list.add(metodo);
         metodo = new Metodo("/**\n*Teste unitário metodo3\n*/",
                a,
                null,
                null, 
                null,
                null, 
                "String", 
                "getTeste3",
                l, 
                "System.out.println(\"teste unitário\");\nreturn \"deu certo\";",
                Boolean.FALSE);
        list.add(metodo);
        return list;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
     public void testHello() {
         System.out.println(enumJava.toString());
     }
}
