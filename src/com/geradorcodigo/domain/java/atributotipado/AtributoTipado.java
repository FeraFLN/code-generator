/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java.atributotipado;

import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.domain.banco.InterfaceAtributo;
import com.geradorcodigo.util.Util;
import java.util.Map;

/**
 *
 * @author T01BRQ0067
 */
public class  AtributoTipado extends Atributo{
    
    private Map<String,String>tipoMap;
    private String comentario;
    
    public AtributoTipado(String comentario, Map<String, String> tipoMap) {
        this.tipoMap = tipoMap;
        this.comentario = comentario;
    }
     
    
    
    protected String getTipo(InterfaceAtributo coluna) {
        if(coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()){
            return Util.converteNomeTabelaToClasse(coluna.getTipo());
        }
        String tipoColuna =coluna.getTipo().toUpperCase();
        if("NUMBER".equals(tipoColuna)&&coluna.getTamanho()>=10){
            tipoColuna = "numberBigger";
        }
        String retorno = tipoMap.get(tipoColuna.toUpperCase());
        return retorno == null ? "Object" : retorno;

    }
    
    protected String getComentarioAtributo() {
        return comentario;
    }
}
