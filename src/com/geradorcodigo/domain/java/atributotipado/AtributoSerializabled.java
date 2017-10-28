/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java.atributotipado;

import com.geradorcodigo.enums.AcessibilidadeEnum;

/**
 *
 * @author T01BRQ0067
 */
public class AtributoSerializabled extends AtributoTipado{

    public AtributoSerializabled() {
        super(null, null);
        setAtributo();
    }
    
    private void setAtributo() {
        setComentario(null);
        setAnotacoes(null);
        setAcessibilidade(AcessibilidadeEnum.PRIVATE); 
        setAtributoFinal(Boolean.TRUE);
        setStatico(Boolean.TRUE);
        setTipo("long");
        setNome("serialVersionUID");
        setValor("1L");
    }

//    @Override
//    private void getAtributo(InterfaceAtributo coluna) {
//        new Atributo(null, null, AcessibilidadeEnum.PRIVATE, Boolean.TRUE, Boolean.TRUE, "long","serialVersionUID", "1L");
//    }
    
}
