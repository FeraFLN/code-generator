/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates.properties;

/**
 *
 * @author T01BRQ0067
 */
public class TemplateBusinessImplGenericoProp extends TemplateProperties{

    private final String idPropComentarioInicial="geradorcodigo.comentarioinicial";
    private final String idPropComentarioClasse="geradorcodigo.businessimpl.comentarioclasse";
    private final String idPropAssinatura="geradorcodigo.businessimpl.assinatura.generic";
    private final String idPropComentarioAtributos="";
    private final String idPropMapTipos="geradorcodigo.businessimpl.anotacoes.";
    
    public TemplateBusinessImplGenericoProp() {
    }
    
    

    @Override
    public String getIdPropAssinatura() {
        return idPropAssinatura;
    }

    @Override
    public String getIdPropComentarioAtributos() {
        return idPropComentarioAtributos;
    }

    @Override
    public String getIdPropComentarioClasse() {
        return idPropComentarioClasse;
    }

    @Override
    public String getIdPropComentarioInicial() {
        return idPropComentarioInicial;
    }

    @Override
    public String getIdPropMapTipos() {
        return idPropMapTipos;
    }
   
}
