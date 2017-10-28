/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.banco;

import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class Check {
    private String nome;
    private String nomeConstraint;
    private List<String> checks;
    private String check;

    public Check() {
    }

    public Check(String nome, String nomeConstraint, List<String> checks) {
        this.nome = nome;
        this.nomeConstraint = nomeConstraint;
        this.checks = checks;
    }

    public List<String> getChecks() {
        return checks;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
    

    public void setChecks(List<String> checks) {
        this.checks = checks;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeConstraint() {
        return nomeConstraint;
    }

    public void setNomeConstraint(String nomeConstraint) {
        this.nomeConstraint = nomeConstraint;
    }

    @Override
    public String toString() {
        if(nome==null || nome.isEmpty()){
            return "";
        }
        if(nomeConstraint==null || nomeConstraint.isEmpty()){
            return "";
        }
        if(check==null || check.isEmpty()){
            return "";
        }
        return " " + nome + " " + nomeConstraint;
    }
    
    
}
