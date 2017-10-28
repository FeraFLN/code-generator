/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates.properties;

/**
 *
 * @author T01BRQ0067
 */
public class TemplateDomainGenericoProp extends TemplateProperties {

    private final String idPropComentarioInicial="geradorcodigo.comentarioinicial";
    private final String idPropComentarioClasse="geradorcodigo.dominio.comentarioclasse";
    private final String idPropAssinatura="geradorcodigo.dominio.assinatura.generic";
    private final String idPropComentarioAtributos="geradorcodigo.dominio.comentario.atributo";
    private final String idPropMapTipos="geradorcodigo.dominio.mapeamento.";
    
    public TemplateDomainGenericoProp() {
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
    

//    @Override
//    protected void readProperties() throws GeradorException {
//        try {
//            properties.load(new FileInputStream(new File("properties" + File.separator + nomeArquivo)));
//            cometarioInicial = properties.getProperty("geradorcodigo.comentarioinicial");
//            cometarioClasse = properties.getProperty("geradorcodigo.dominio.comentarioclasse");
//            assinatura = properties.getProperty("geradorcodigo.dominio.assinatura.generic");
//            if ("".equals(Util.getString(assinatura))) {
//                throw new GeradorException("Não foi possivel encontrar o \"geradorcodigo.dominio.assinatura.generic\" no properties "+nomeArquivo);
//            }
//            comentarioAtributo = properties.getProperty("geradorcodigo.dominio.comentario.atributo");
//        } catch (IOException ex) {
//            throw new GeradorException("Erro ao tentar lêr o arquivo " + nomeArquivo + ".", ex.getMessage());
//        }
//
//    }

//    @Override
//    public Map<String, String> getMapTipos() throws GeradorException {
//        readProperties();
//        String initKey = idPropMapTipos;
//        Map<String, String> retorno = new HashMap<String, String>();
//        Set<Object> keys = properties.keySet();
//        for (Object object : keys) {
//            if (object.toString().startsWith(initKey)) {
//                String key = object.toString().replace(initKey, "").toUpperCase();
//                retorno.put(key, properties.getProperty(object.toString()));
//            }
//        }
//        return retorno;
//    }
//    public static void main(String[] args) {
//        TemplateDomainGenericoProp t= new TemplateDomainGenericoProp();
//        Map<String,String> result = t.getMapTipos();
//        for (String string : result.keySet()) {
//            System.out.println("key "+string+" value "+result.get(string));
//        }
//    }
}
