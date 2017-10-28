/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.templates;

import com.geradorcodigo.templates.properties.TemplateBeanGenericoProp;
import com.geradorcodigo.templates.properties.TemplateBusinessGenericoProp;
import com.geradorcodigo.templates.properties.TemplateBusinessImplGenericoProp;
import com.geradorcodigo.templates.properties.TemplateDaoGenericoProp;
import com.geradorcodigo.templates.properties.TemplateDaoImplGenericoProp;
import com.geradorcodigo.templates.properties.TemplateDomainGenericoProp;
import com.geradorcodigo.templates.properties.TemplateExcecaoBusinessGenericoProp;

/**
 *
 * @author T01BRQ0067
 */
public class FactoryTemplate {
    public static final int TEMPLATE_DOMAIN_GENERICO=0;
    public static final int TEMPLATE_DAOIMPL_GENERICO=1;
    public static final int TEMPLATE_DAO_GENERICO=2;
    public static final int TEMPLATE_BUSINESS_IMPL_GENERICO=3;
    public static final int TEMPLATE_BUSINESS_GENERICO=4;
    public static final int TEMPLATE_BUSINESS_EXCECAO=5;
    public static final int TEMPLATE_BEAN_GENERICO=6;
    
    
    public static Template getTemplate(int template){
        if(template==TEMPLATE_DOMAIN_GENERICO){
            return new TemplateDomainGenericoProp();
        }else if(template==TEMPLATE_DAOIMPL_GENERICO){
            return new TemplateDaoImplGenericoProp();
        }else if(template==TEMPLATE_DAO_GENERICO){
            return new TemplateDaoGenericoProp();
        }else if(template==TEMPLATE_BUSINESS_IMPL_GENERICO){
            return new TemplateBusinessImplGenericoProp();
        }else if(template==TEMPLATE_BUSINESS_GENERICO){
            return new TemplateBusinessGenericoProp();
        }else if(template==TEMPLATE_BUSINESS_EXCECAO){
            return new TemplateExcecaoBusinessGenericoProp();
        }else if(template==TEMPLATE_BEAN_GENERICO){
            return new TemplateBeanGenericoProp();
        }
        return null;
    }
}
