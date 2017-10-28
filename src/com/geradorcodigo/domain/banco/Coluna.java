/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.banco;

/**
 *
 * @author T01BRQ0067
 */
public class Coluna implements InterfaceAtributo{
    private Boolean primaryKey;
    private Tabela tabela;
    private String nome;
    private String tipo;
    private Integer tamanho;
    private Boolean nullable;
    private String comentario;
    private Check check;
    private Forengkey forengkey;
    
    
    public Coluna() {
    }

//    public Coluna(Tabela tabela, String nome, String tipo, Integer tamanho, Boolean nullable, String comentario, Check check, Forengkey forengkey) {
//        this.tabela = tabela;
//        this.nome = nome;
//        this.tipo = tipo;
//        this.tamanho = tamanho;
//        this.nullable = nullable;
//        this.comentario = comentario;
//        this.check = check;
//        this.forengkey = forengkey;
//    }

    public Coluna(Boolean primaryKey, Tabela tabela, String nome, String tipo, Integer tamanho, Boolean nullable, String comentario, Check check, Forengkey forengkey) {
        this.primaryKey = primaryKey;
        this.tabela = tabela;
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.nullable = nullable;
        this.comentario = comentario;
        this.check = check;
        this.forengkey = forengkey;
    }

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    
    @Override
    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    @Override
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Forengkey getForengkey() {
        return forengkey;
    }

    public void setForengkey(Forengkey forengkey) {
        this.forengkey = forengkey;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    
    @Override
    public String toString () {
        return  nome + "  " + tipo + "(" + tamanho + ")  " + nullable + "  "+check +" "+forengkey+ " primarykey "+primaryKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coluna other = (Coluna) obj;
        if (this.tabela != other.tabela && (this.tabela == null || !this.tabela.equals(other.tabela))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo)) {
            return false;
        }
        if (this.tamanho != other.tamanho && (this.tamanho == null || !this.tamanho.equals(other.tamanho))) {
            return false;
        }
        if (this.nullable != other.nullable && (this.nullable == null || !this.nullable.equals(other.nullable))) {
            return false;
        }
        if ((this.comentario == null) ? (other.comentario != null) : !this.comentario.equals(other.comentario)) {
            return false;
        }
        if (this.check != other.check && (this.check == null || !this.check.equals(other.check))) {
            return false;
        }
        if (this.forengkey != other.forengkey && (this.forengkey == null || !this.forengkey.equals(other.forengkey))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.tabela != null ? this.tabela.hashCode() : 0);
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 29 * hash + (this.tamanho != null ? this.tamanho.hashCode() : 0);
        hash = 29 * hash + (this.nullable != null ? this.nullable.hashCode() : 0);
        hash = 29 * hash + (this.comentario != null ? this.comentario.hashCode() : 0);
        hash = 29 * hash + (this.check != null ? this.check.hashCode() : 0);
        hash = 29 * hash + (this.forengkey != null ? this.forengkey.hashCode() : 0);
        return hash;
    }

    @Override
    public String getNomeTabela() {
        return (tabela!= null && tabela.getNome()!=null)?tabela.getNome():null;
    }

    

    
}
