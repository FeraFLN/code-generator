/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates.properties;

/**
 *
 * @author T01BRQ0067
 */
public class TemplateDaoGenericoProp extends  TemplateProperties  {
    private final String idPropComentarioInicial="geradorcodigo.comentarioinicial";
    private final String idPropComentarioClasse="geradorcodigo.dao.comentarioclasse";
    private final String idPropAssinatura="geradorcodigo.dao.assinatura.generic";
    private final String idPropComentarioAtributos="";
    private final String idPropMapTipos="";
    
    

//    @Override
//    protected void readProperties() throws GeradorException {
//        try {
//            properties.load(new FileInputStream(new File("properties"+File.separator+nomeArquivo)));
//            cometarioInicial= properties.getProperty("geradorcodigo.comentarioinicial");
//            cometarioClasse= properties.getProperty("geradorcodigo.dao.comentarioclasse");
//            assinatura= properties.getProperty("geradorcodigo.dao.assinatura.generic");
//            if ("".equals(Util.getString(assinatura))) {
//                throw new GeradorException("Não foi possivel encontrar o \"geradorcodigo.dominio.assinatura.generic\" no properties "+nomeArquivo);
//            }
//        } catch (IOException ex) {
//            throw new GeradorException("Erro ao tentar lêr o arquivo "+nomeArquivo+".", ex.getMessage());
//        }
//    }

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
