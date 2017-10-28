/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import com.geradorcodigo.domain.java.AssinaturaMetodo;
import com.geradorcodigo.domain.java.AtributoMetodo;
import com.geradorcodigo.domain.java.InterfaceJava;
import com.geradorcodigo.enums.AcessibilidadeEnum;

/**
 *
 * @author T01BRQ0067
 */
public class TesteInterfaceJava extends TestCase {
    private InterfaceJava interfaceJava;
    public TesteInterfaceJava(String testName) {
        super(testName);
        interfaceJava= new InterfaceJava();
        interfaceJava.setAcessibilidade(AcessibilidadeEnum.PUBLIC);
        interfaceJava.setAnotacoes(Arrays.asList("@Transactionrollback","@TesteUnitario"));
        interfaceJava.setAssinaturaMetodos(getAssinaturaMetodo());
        interfaceJava.setComentarioClasse("/**\n *classe para testes unitários\n**/");
        interfaceJava.setComentarioInicial("/*\n * To change this template, choose Tools | Templates\n * and open the template in the editor.\n */");
         List<String> importacao = Arrays.asList("import main.java.com.geradorcodigo.domain.Atributo;",
                                                 "import main.java.com.geradorcodigo.domain.AtributoMetodo;",
                                                 "import main.java.com.geradorcodigo.domain.JavaObjeto;");
        interfaceJava.setImportacoes(importacao);
        interfaceJava.setMaiorMenor("T");
        interfaceJava.setNome("Teste");
        interfaceJava.setObjetoAbstrato(Boolean.TRUE);
        interfaceJava.setObjetoExtendido("List<String>");
        interfaceJava.setPkg("com.geradorcodigo.testesunitarios;");
    }
      private List<AssinaturaMetodo> getAssinaturaMetodo() {
        List<AtributoMetodo> l = Arrays.asList(new AtributoMetodo(Boolean.FALSE, "String", "teste"),
                new AtributoMetodo(Boolean.FALSE, "String", "teste1"));
        List<String> a = Arrays.asList("@Teste", "@String");
        List<AssinaturaMetodo> list = new ArrayList<AssinaturaMetodo>();
        AssinaturaMetodo metodo = new AssinaturaMetodo("/**\n*Teste unitário metodo\n*/",
                a,
                AcessibilidadeEnum.PUBLIC,
                Boolean.TRUE, Boolean.TRUE,
                "T", "String", "getTeste",
                l,
                Boolean.FALSE);
        list.add(metodo);
        metodo = new AssinaturaMetodo("/**\n*Teste unitário metodo2\n*/",
                a,
                AcessibilidadeEnum.PUBLIC,
                Boolean.TRUE, Boolean.TRUE,
                "T", "String", "getTeste2",
                l, 
                Boolean.FALSE);
        list.add(metodo);
         metodo = new AssinaturaMetodo("/**\n*Teste unitário metodo3\n*/",
                a,
                null,
                null, 
                null,
                null, 
                "String", 
                "getTeste3",
                l, 
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
    
     public void testClasseCompleta1() {
        String resultadoEsperado = "/*"
                                +"\n * To change this template, choose Tools | Templates"
                                +"\n * and open the template in the editor."
                                +"\n */"
                                +"\npackage com.geradorcodigo.testesunitarios;"
                                +"\nimport main.java.com.geradorcodigo.domain.Atributo;"
                                +"\nimport main.java.com.geradorcodigo.domain.AtributoMetodo;"
                                +"\nimport main.java.com.geradorcodigo.domain.JavaObjeto;"
                                +"\n/**"
                                +"\n *classe para testes unitários"
                                +"\n**/"
                                +"\n@Transactionrollback"
                                +"\n@TesteUnitario"
                                +"\npublic abstract interface Teste <T> extends List<String> {"
                                +"\n"
                                +"\n	/**"
                                +"\n	*Teste unitário metodo"
                                +"\n	*/"
                                +"\n	@Teste"
                                +"\n	@String"
                                +"\n	public static final <T> String getTeste(String teste,String teste1);\n\t"
                                +"\n	/**"
                                +"\n	*Teste unitário metodo2"
                                +"\n	*/"
                                +"\n	@Teste"
                                +"\n	@String"
                                +"\n	public static final <T> String getTeste2(String teste,String teste1);\n\t"
                                +"\n	/**"
                                +"\n	*Teste unitário metodo3"
                                +"\n	*/"
                                +"\n	@Teste"
                                +"\n	@String"
                                +"\n	String getTeste3(String teste,String teste1);"
                                +"\n"
                                +"\n}";
        System.out.println(interfaceJava);
        assertEquals(resultadoEsperado, interfaceJava.toString());
    }
}
