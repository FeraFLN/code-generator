/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java.atributotipado;

import com.geradorcodigo.domain.banco.InterfaceAtributo;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.util.Util;
import java.util.Map;

/**
 *
 * @author T01BRQ0067
 */
public class AtributoSimples extends AtributoTipado{


    public AtributoSimples(InterfaceAtributo coluna,String comentario,Map<String,String> tipos) {
        super(comentario, tipos);
        setAtributo(coluna);
    }
    
    private void setAtributo(InterfaceAtributo coluna) {
        String con = getComentarioAtributo();
        this.setComentario(con);
        this.setAnotacoes(null);
        this.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        this.setAtributoFinal(Boolean.FALSE);
        this.setStatico(Boolean.FALSE);
        this.setTipo(getTipo(coluna));
        this.setNome(Util.converteNomeColunaToAtri(coluna.getNome()));
    }
    

}
