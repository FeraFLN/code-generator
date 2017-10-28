/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates.properties;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author T01BRQ0067
 */
public abstract class TemplateProperties implements Template{
    protected  Properties properties;
    protected final String nomeArquivo="genericTemplate.properties";
    protected String cometarioInicial;
    protected String cometarioClasse;
    protected String comentarioAtributo;
    protected String assinatura;

    public TemplateProperties() {
         properties = new Properties();
    }
    
    protected abstract String getIdPropComentarioInicial();
    
    protected abstract String getIdPropComentarioClasse();
    
    protected abstract String getIdPropAssinatura();
    
    protected abstract String getIdPropComentarioAtributos();
    
    protected abstract String getIdPropMapTipos();
    
    protected void readProperties() throws GeradorException {
        try {
            properties.load(new FileInputStream(new File("properties"+File.separator+nomeArquivo)));
            cometarioInicial= properties.getProperty(getIdPropComentarioInicial());
            cometarioClasse= properties.getProperty(getIdPropComentarioClasse());
            assinatura= properties.getProperty(getIdPropAssinatura());
            if ("".equals(Util.getString(assinatura))) {
                throw new GeradorException("Não foi possivel encontrar o id: \""+getIdPropAssinatura()+"\" no properties: \""+nomeArquivo+"\"");
            }
            comentarioAtributo = properties.getProperty(getIdPropComentarioAtributos());
        } catch (IOException ex) {
            throw new GeradorException("Erro ao tentar lêr o arquivo "+nomeArquivo+".", ex.getMessage());
        }
    }
    
    //protected abstract void readProperties()throws GeradorException;
    
    @Override
    public String getComentarioClasse() throws GeradorException {
        readProperties();
        return cometarioClasse;
    }

    @Override
    public String getComentarioInicial() throws GeradorException{
        readProperties();
        return cometarioInicial;
    }

    @Override
    public String getAssinaturaClasse() throws GeradorException{
        readProperties();
        return assinatura;
    }

    @Override
    public String getComentarioAtributos()throws GeradorException {
        readProperties();
        return comentarioAtributo;
    }
    
    @Override
    public Map<String, String> getMapTipos() throws GeradorException{
         readProperties();
        String initKey = getIdPropMapTipos();
        Map<String, String> retorno = new LinkedHashMap<String,String>();
        Set<Object> keys = properties.keySet();
        for (Object object : keys) {
            if (object.toString().startsWith(initKey)) {
                String key = object.toString().replace(initKey, "").toUpperCase();
                retorno.put(key, properties.getProperty(object.toString()));
            }
        }
        return retorno;
    }
}
