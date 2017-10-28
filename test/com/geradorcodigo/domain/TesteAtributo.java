/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.enums.AcessibilidadeEnum;

/**
 *
 * @author T01BRQ0067
 */
public class TesteAtributo extends TestCase {
    private Atributo atributo;
    private String comentario ="/*\n*teste unitário\n*/";
    private List<String> anotacoes = Arrays.asList("@Teste","@Entity");
    
    public TesteAtributo(String testName) {
        super(testName);
        atributo=new Atributo(comentario, anotacoes, AcessibilidadeEnum.PUBLIC, Boolean.TRUE, Boolean.TRUE,"String","testeUnitário","\"testesucesso\"");
        
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    // Teste acessibilidade inicio:
    
    public void testSucessoTudoPublico() {
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic static final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoTudoPrivate() {
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate static final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoTudoProtected() {
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected static final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    
    public void testSucessoTudoSemAcessibilidade() {
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nstatic final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    // Teste acessibilidade fim:
    
    // Teste statico inicio:
    public void testSucessoNaoStaticoPublico() {
        atributo.setStatico(Boolean.FALSE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoStaticoPrivate() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoStaticoProtected() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    
    public void testSucessoNaoStaticoSemAcessibilidade() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nfinal String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    // Teste statico fim:
    
    // Teste final inicio:
    public void testSucessoNaoFinalPublico() {
        atributo.setAtributoFinal(Boolean.FALSE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic static String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoFinalPrivate() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate static String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoFinalProtected() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected static String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    
    public void testSucessoNaoFinalSemAcessibilidade() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nstatic String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    // Teste final fim:
    // Teste statico final inicio:
    public void testSucessoNaoFinalNaoStaticoPublico() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setStatico(Boolean.FALSE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoFinalNaoStaticoPrivate() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoFinalNaoStaticoProtected() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    
    public void testSucessoNaoFinalNaoStaticoSemAcessibilidade() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nString testeUnitário = \"testesucesso\";", atributo.toString());
    }
    // Teste final statico fim:
    
    // Teste valor inicio:
    
    public void testSucessoTudoPublicoSemValor() {
        atributo.setValor("");
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic static final String testeUnitário;", atributo.toString());
    }
    public void testSucessoTudoPrivateSemValor() {
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        atributo.setValor("");
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate static final String testeUnitário;", atributo.toString());
    }
    public void testSucessoTudoProtectedSemValor() {
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        atributo.setValor("");
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected static final String testeUnitário;", atributo.toString());
    }
    
    public void testSucessoTudoSemAcessibilidadeSemValor() {
        atributo.setAcessibilidade(null);
        atributo.setValor("");
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nstatic final String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoStaticoPublicoSemValor() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setValor("");
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic final String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoStaticoPrivateSemValor() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setValor("");
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate final String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoStaticoProtectedSemValor() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setValor("");
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected final String testeUnitário;", atributo.toString());
    }
    
    public void testSucessoNaoStaticoSemAcessibilidadeSemValor() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setValor("");
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nfinal String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoFinalPublicoSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic static String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoFinalPrivateSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate static String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoFinalProtectedSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected static String testeUnitário;", atributo.toString());
    }
    
    public void testSucessoNaoFinalSemAcessibilidadeSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nstatic String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoFinalNaoStaticoPublicoSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setStatico(Boolean.FALSE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\npublic String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoFinalNaoStaticoPrivateSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprivate String testeUnitário;", atributo.toString());
    }
    public void testSucessoNaoFinalNaoStaticoProtectedSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nprotected String testeUnitário;", atributo.toString());
    }
    
    public void testSucessoNaoFinalNaoStaticoSemAcessibilidadeSemValor() {
        atributo.setAtributoFinal(Boolean.FALSE);
        atributo.setValor("");
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\n@Teste\n@Entity\nString testeUnitário;", atributo.toString());
    }
    // Teste valor fim:
    //Teste valor sem anotacao inicio:
    public void testSucessoTudoPublicoSemAnotacao() {
        atributo.setAnotacoes(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\npublic static final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoTudoPrivateSemAnotacao() {
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        atributo.setAnotacoes(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\nprivate static final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoTudoProtectedSemAnotacao() {
        atributo.setAnotacoes(null);
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\nprotected static final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    
    public void testSucessoTudoSemAcessibilidadeSemAnotacao() {
        atributo.setAcessibilidade(null);
        atributo.setAnotacoes(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\nstatic final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
   
    public void testSucessoNaoStaticoPublicoSemAnotacao() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAnotacoes(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\npublic final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoStaticoPrivateSemAnotacao() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAnotacoes(null);
        atributo.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\nprivate final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    public void testSucessoNaoStaticoProtectedSemAnotacao() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAnotacoes(null);
        atributo.setAcessibilidade(AcessibilidadeEnum.PROTECTED);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\nprotected final String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    
    public void testSucessoNaoStaticoSemAcessibilidadeSemAnotacao() {
        atributo.setStatico(Boolean.FALSE);
        atributo.setAcessibilidade(null);
        atributo.setAnotacoes(null);
        System.out.println(atributo);
        assertEquals("/*\n*teste unitário\n*/\nfinal String testeUnitário = \"testesucesso\";", atributo.toString());
    }
    //Teste valor sem anotacao fim:
    
}
