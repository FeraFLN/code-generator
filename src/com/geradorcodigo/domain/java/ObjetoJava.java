/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java;

import com.geradorcodigo.enums.AcessibilidadeEnum;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public interface ObjetoJava {

    public String getNome();
    
    public String getPkg();
    
    public void setPkg(String valor);
    
    public AcessibilidadeEnum getAcessibilidade();
    
    public void setAcessibilidade(AcessibilidadeEnum acessibilidadeEnum);

    public void setObjetoAbstrato(Boolean isObjetoAbstrato);

    public void setMaiorMenor(String maiorMenor);

    public void setObjetoExtendido(String extendido);
    
    public void setComentarioInicial(String extendido);
    
    public void setComentarioClasse(String extendido);

    public void setObjetosImplementados(List<String> implementados);
}
