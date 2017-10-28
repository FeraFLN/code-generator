/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders.classe.generica;

import com.geradorcodigo.domain.java.atributotipado.AtributoDominioGenerico;
import com.geradorcodigo.domain.java.atributotipado.AtributoSerializabled;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.java.Atributo;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author T01BRQ0067
 */
public class BuilderAtributoDomainGenerico {
    
    
    public List<Atributo> builderAtributos(List<Coluna> colunasAtributo,String comentarioDefault,Map<String,String> map,String colunaDescricao,String idColuna) {
        List<Atributo> atributos = new ArrayList<Atributo>();
        atributos.add(new AtributoSerializabled());
        for (Coluna coluna : Util.replaceFks(colunasAtributo,comentarioDefault)) {
            atributos.add(new AtributoDominioGenerico(coluna,null, map,colunaDescricao,idColuna));
        }
        return atributos;
    }
}
