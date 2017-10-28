/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.builders;

import com.geradorcodigo.builders.exception.generica.BuilderGenericException;
import com.geradorcodigo.domain.java.InterfaceJava;
import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.domain.java.ObjetoJava;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.templates.Template;
import com.geradorcodigo.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author T01BRQ0067
 */
public abstract class AbstractBuilder<T extends ObjetoJava> {//\\[*\\w+\\]*
   private final String regexAssinaturaClasse="(public\\s+|private\\s+|)(abstract\\s+|)(class\\s+|enum\\s+|interface\\s+)([a-zA-Z0-9\\[\\]_]+)(\\s*<(\\w+\\s*)+>|)(\\s+extends\\s+([a-zA-Z]+(<[a-zA-Z0-9,<> ]+>|))|)(\\s+implements\\s+(\\w+)|)" ;   
//   private final String regexAssinaturaClasse="(public\\s+|private\\s+)*(abstract\\s+)*(class\\s+|enum\\s+|interface\\s+)(\\[*\\w+\\]*)(\\s*<\\[*(\\w+\\s*)+\\]*>)*(\\s+extends\\s*((\\[*\\w+\\]*)(\\s*<(\\[*<*\\w+>*\\]*\\s*,*\\s*)+>)*))*(\\s+implements\\s+((\\s*\\[*\\w+\\]*(\\s*<\\[*\\w+\\]*>)*,*)+))*" ;   
//  private final String regexAssinaturaClasse="(public\\s+|private\\s+|)(abstract\\s+|)(class\\s+|enum\\s+|interface\\s+)([a-zA-Z0-9]+)(\\s*<(\\w+\\s*)+>|)(\\s+extends\\s|((\\w+)(\\s*<(<*\\w+>*\\s*,*\\s*)+>|)))*(\\s+implements\\s+((\\s|\\w+(\\s*<\\w+>)*,*)+)|)" ;   
//    private final String regexAssinaturaClasse="(|public\\s+|private\\s+)(|abstract\\s+)(class\\s+|enum\\s+|interface\\s+)((\\[|)\\w+(\\]|))(\\s+<\\w>|<\\w>|)(\\s+extends|\\s+implements|)(\\s+\\w+|)(\\s+implements|)(\\s+(\\w+(,\\s+|,|))+|)" ;   
    private T objetoJava;
    private String comentarioInicial;
    private String comentarioClasse;
    private String assinaturaClasse;
    private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private Object object;
    private String pkg;
    private String nomeAutor;
    
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    private T getNewObject() throws GeradorException {
        try {
            ParameterizedType type = (ParameterizedType) getClass()
            .getGenericSuperclass();
            Class<T> theType = (Class<T>) type.getActualTypeArguments()[0];
            Constructor<T> constructor = theType.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException ex) {
            throw new GeradorException("Construtor não encontrado.", ex.getMessage());
        } catch (Exception ex) {
            throw new GeradorException("Erro a criar o construtor.", ex.getMessage());
        }
	}
    
    public AbstractBuilder(Object object, String nomeAutor, String pkg) throws GeradorException {
        this.objetoJava = getNewObject();
        this.object=object;
        this.nomeAutor=nomeAutor;
        this.pkg=pkg;
    }

    public AbstractBuilder(T objetoJava){
        this.objetoJava = objetoJava;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object o) {
        this.object = o;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }
    
    //public abstract ObjetoJava builder2(String nomeDominio, String nomeAutor, String pkg) throws BuilderGenericException ;
    protected abstract void replacesClasseJava() throws GeradorException;
    
    public abstract T builder() throws BuilderGenericException ;
    
    public abstract Template getTemplate();
    
    protected T builder2() throws GeradorException{
        inicializarVariaveis();
        objetoJava.setComentarioInicial(getComentarioInicial());
        replacesClasseJava();
        assinaturaClasse();
        return objetoJava;
    }
    
    protected  void inicializarVariaveis() throws GeradorException{
        comentarioClasse=getTemplate().getComentarioClasse();
        comentarioInicial=getTemplate().getComentarioInicial();
        assinaturaClasse=getTemplate().getAssinaturaClasse();
    }
    
    protected void assinaturaClasse(){
        Pattern pattern = Pattern.compile(regexAssinaturaClasse,Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(assinaturaClasse);
        if(matcher.find()){
           String acessibilidade =  Util.getString(matcher.group(1)).trim();
           String abstrato =  Util.getString(matcher.group(2));
           String maiorMenor =  Util.getString(matcher.group(5));
           String extendido =  Util.getString(matcher.group(8));
           String implementados =  Util.getString(matcher.group(11)).replace(" ", "").trim();
           
           objetoJava.setAcessibilidade(AcessibilidadeEnum.value(acessibilidade));  
           objetoJava.setObjetoAbstrato(!abstrato.isEmpty());  
           objetoJava.setMaiorMenor(maiorMenor.replace("<", "").replace(">", "").trim());  
           objetoJava.setObjetoExtendido(extendido.trim());  
           if(!"".equals(Util.getString(implementados))){
               objetoJava.setObjetosImplementados(Arrays.asList(implementados.split(",")));  
           }
        }
    }

    public String getAssinaturaClasse() {
        return assinaturaClasse;
    }

    public String getComentarioClasse() {
        return comentarioClasse;
    }

    public String getComentarioInicial() {
        return comentarioInicial;
    }

    public void setAssinaturaClasse(String assinaturaClasse) {
        this.assinaturaClasse = assinaturaClasse;
    }


    public ObjetoJava getClasseJava() {
        return objetoJava;
    }
    
}
