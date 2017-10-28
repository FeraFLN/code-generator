/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.gui.classe.panel;

import com.geradorcodigo.builders.xml.mybatis.BuilderXmlMybatis;
import com.geradorcodigo.exception.GeradorException;
import javax.swing.JPanel;

/**
 *
 * @author T01BRQ0067
 */
public class PnlXml extends JPanel implements PanelFrame{
    private static final long serialVersionUID = 1L;
    
    private BuilderXmlMybatis builderXmlMybatis;
    private PnlTextoClasse pnlTextoClasse;
    private String texto;
    private String nomeArquivo;
    
    public PnlXml(BuilderXmlMybatis builderXmlMybatis,String nomeArquivo) throws GeradorException {
        this.nomeArquivo = nomeArquivo;
        this.builderXmlMybatis = builderXmlMybatis;
        texto=builderXmlMybatis.marshall();
        pnlTextoClasse = new PnlTextoClasse(texto);
        this.setLayout(new java.awt.GridLayout(1, 1));
        this.add(pnlTextoClasse);
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    
    
    public BuilderXmlMybatis getBuilderXmlMybatis() {
        return builderXmlMybatis;
    }

    @Override
    public String getLocalArquivo() {
        return "";
    }
    
    
    
}
