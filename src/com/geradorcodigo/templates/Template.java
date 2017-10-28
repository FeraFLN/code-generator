/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates;

import com.geradorcodigo.exception.GeradorException;
import java.util.Map;

/**
 *
 * @author T01BRQ0067
 */
public interface Template {

    public String getComentarioClasse() throws GeradorException;

    public String getComentarioInicial()throws GeradorException;

    public String getAssinaturaClasse()throws GeradorException;
    
    public String getComentarioAtributos()throws GeradorException;
    
    public Map<String,String> getMapTipos()throws GeradorException;
}
