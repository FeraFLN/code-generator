/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.domain.java.atributotipado;

import com.geradorcodigo.domain.banco.InterfaceAtributo;
import com.geradorcodigo.enums.AcessibilidadeEnum;
import com.geradorcodigo.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author T01BRQ0067
 */
public class AtributoDominioGenerico extends AtributoTipado {
    private final String anotationDefault ="[NOME_CAMPO] não informada(o).";
    public AtributoDominioGenerico(InterfaceAtributo coluna, String comentario, Map<String, String> tipoMap, String colunaDescricao, String idColuna) {
        super(comentario, tipoMap);
        setAtributo(coluna, colunaDescricao, idColuna);
    }

    private void setAtributo(InterfaceAtributo coluna, String colunaDescricao, String idColuna) {
        String con = getComentarioAtributo() == null || "".equals(getComentarioAtributo()) ? coluna.getComentario() : getComentarioAtributo();

        this.setComentario(con);
        this.setAnotacoes(getAnotacoes(coluna, colunaDescricao, idColuna));
        this.setAcessibilidade(AcessibilidadeEnum.PRIVATE);
        this.setAtributoFinal(Boolean.FALSE);
        this.setStatico(Boolean.FALSE);
        this.setTipo(getTipo(coluna));
        if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {
            this.setNome(Util.converteNomeColunaToAtri(coluna.getTipo()));
        } else {
            this.setNome(Util.converteNomeColunaToAtri(coluna.getNome()));

        }
    }

    private List<String> getAnotacoes(InterfaceAtributo coluna, String colunaDescricao, String idColuna) {
        List<String> listaAnotacao = new ArrayList<String>();
        if (Boolean.FALSE.equals(coluna.getNullable())) {
            if ("varchar2".equalsIgnoreCase(coluna.getTipo())) {
                listaAnotacao.add("@NotEmpty(message=\""+anotationDefault+"\")");
            } else {
                listaAnotacao.add("@NotNull(message=\""+anotationDefault+"\")");
            }
            if (coluna.getNome().equalsIgnoreCase(colunaDescricao)) {
                listaAnotacao.add("@DescriptionEntity");
            }
            if (coluna.getNome().equalsIgnoreCase(idColuna)) {
                if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {
                    listaAnotacao.add("@IdEntity(\"" + Util.converteNomeTabelaToClasse(coluna.getForengkey().getColunaReferenciada()) + "\")");
                } else {
                    listaAnotacao.add("@IdEntity");
                }
            }
            if (coluna.getForengkey() != null && !coluna.getForengkey().isEmpty()) {
                listaAnotacao.add("@ValidEntity(message=\""+anotationDefault+"\", value= \"" + Util.converteNomeTabelaToClasse(coluna.getForengkey().getColunaReferenciada()) + "\")");
            }
        }
        return listaAnotacao;
    }
}
