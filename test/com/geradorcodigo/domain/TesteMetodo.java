/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.java.AtributoMetodo;
import com.geradorcodigo.domain.java.Metodo;
import com.geradorcodigo.enums.AcessibilidadeEnum;

/**
 *
 * @author T01BRQ0067
 */
public class TesteMetodo extends TestCase {
    private Metodo metodo;
    
    public TesteMetodo(String testName) {
        super(testName);
        List<AtributoMetodo> l = Arrays.asList(new AtributoMetodo(Boolean.FALSE, "String", "teste"),
                new AtributoMetodo(Boolean.FALSE, "String", "teste1"));
        List<String> a = Arrays.asList("@Teste","@String");
        metodo=new Metodo("/**\n*Teste unitário metodo\n*/",
                a, 
                AcessibilidadeEnum.PUBLIC, 
                Boolean.TRUE, Boolean.TRUE, 
                "T", "String", "getTeste",
                l, "System.out.println(\"teste unitário\");\nreturn \"deu certo\";",Boolean.FALSE);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    public void testMetodoCompleto() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
    public void testMetodoSemAtributo() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public static final <T> String getTeste(){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAtributos(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
    
    public void testMetodoSemT() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public static final String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemRetorno() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public static final <T> void getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setRetorno("");
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemFinalNull() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public static <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMetodoFinal(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemFinalFalse() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public static <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMetodoFinal(Boolean.FALSE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     
       public void testMetodoSemStaticoNull() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setStatico(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }  
       public void testMetodoSemStaticoFalse() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setStatico(Boolean.FALSE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSemAnotacao() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "public static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAnotacoes(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       
        public void testMetodoAcessibilidadeNull() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAcessibilidade(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSemComentario() {
        String valorEsperado ="@Teste\n"
                             + "@String\n"
                             + "public static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setComentario("");
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoComentarioNull() {
        String valorEsperado ="@Teste\n"
                             + "@String\n"
                             + "public static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setComentario(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSimplesComAtributo() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSimplesSemAtributo() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "public String getTeste(){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        metodo.setAtributos(null);
        
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       
       
       //testes protected
        public void testMetodoCompletoprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        System.out.println(metodo);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        assertEquals(valorEsperado, metodo.toString());
    }
    public void testMetodoSemAtributoprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected static final <T> String getTeste(){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAtributos(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
    
    public void testMetodoSemTprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected static final String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemRetornoprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected static final <T> void getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setRetorno("");
        System.out.println(metodo);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemFinalNullprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected static <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMetodoFinal(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemFinalFalseprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected static <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     
       public void testMetodoSemStaticoNullprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setStatico(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }  
       public void testMetodoSemStaticoFalseprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setStatico(Boolean.FALSE);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSemAnotacaoprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "protected static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAnotacoes(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       
       
       public void testMetodoSemComentarioprotected() {
        String valorEsperado ="@Teste\n"
                             + "@String\n"
                             + "protected static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setComentario("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoComentarioNullprotected() {
        String valorEsperado ="@Teste\n"
                             + "@String\n"
                             + "protected static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setComentario(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSimplesComAtributoprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSimplesSemAtributoprotected() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "protected String getTeste(){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        metodo.setAtributos(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       //metodos privados
       public void testMetodoCompletoprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
    public void testMetodoSemAtributoprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private static final <T> String getTeste(){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAtributos(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
    
    public void testMetodoSemTprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private static final String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemRetornoprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private static final <T> void getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setRetorno("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemFinalNullprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private static <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMetodoFinal(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     public void testMetodoSemFinalFalseprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private static <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     
       public void testMetodoSemStaticoNullprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setStatico(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }  
       public void testMetodoSemStaticoFalseprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setStatico(Boolean.FALSE);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSemAnotacaoprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "private static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setAnotacoes(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       
       
       public void testMetodoSemComentarioprivate() {
        String valorEsperado ="@Teste\n"
                             + "@String\n"
                             + "private static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setComentario("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoComentarioNullprivate() {
        String valorEsperado ="@Teste\n"
                             + "@String\n"
                             + "private static final <T> String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setComentario(null);
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSimplesComAtributoprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoSimplesSemAtributoprivate() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "@Teste\n"
                             + "@String\n"
                             + "private String getTeste(){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
        metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        metodo.setAtributos(null);
        
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       
       public void testMetodoSimples() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "public String getTeste(String teste,String teste1){\n"
                             + "\tSystem.out.println(\"teste unitário\");\n"
                             + "\treturn \"deu certo\";\n"
                             + "}";
        metodo.setMaiorMenor("");
       // metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        metodo.setAnotacoes(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
       public void testMetodoAbstratoSimples() {
        String valorEsperado ="/**\n"
                             + "*Teste unitário metodo\n"
                             + "*/\n"
                             + "public abstract String getTeste(String teste,String teste1);\n";
        metodo.setMaiorMenor("");
        metodo.setAbstrato(Boolean.TRUE);
       // metodo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        metodo.setMetodoFinal(Boolean.FALSE);
        metodo.setStatico(Boolean.FALSE);
        metodo.setAnotacoes(null);
        System.out.println(metodo);
        assertEquals(valorEsperado, metodo.toString());
    }
     
}
