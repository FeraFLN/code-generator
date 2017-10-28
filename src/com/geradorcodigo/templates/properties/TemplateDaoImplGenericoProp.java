/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates.properties;

/**
 *
 * @author T01BRQ0067
 */
public class TemplateDaoImplGenericoProp extends TemplateProperties{

    private final String idPropComentarioInicial="geradorcodigo.comentarioinicial";
    private final String idPropComentarioClasse="geradorcodigo.daoimpl.comentarioclasse";
    private final String idPropAssinatura="geradorcodigo.daoimpl.assinatura.generic";
    private final String idPropComentarioAtributos="";
    private final String idPropMapTipos="geradorcodigo.daoimpl.anotacoes.";
    
    public TemplateDaoImplGenericoProp() {
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
