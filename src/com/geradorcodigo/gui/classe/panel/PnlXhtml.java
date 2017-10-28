/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.gui.classe.panel;

import com.geradorcodigo.exception.GeradorException;
import java.io.File;
import javax.swing.JPanel;

/**
 *
 * @author T01BRQ0067
 */
public class PnlXhtml extends JPanel implements PanelFrame{
    private static final long serialVersionUID = 1L;
    
    private PnlTextoClasse pnlTextoClasse;
    private String texto;
    private String nomeArquivo;
    
    public PnlXhtml(String texto,String nomeArquivo) throws GeradorException {
        this.texto=texto;
        this.nomeArquivo = nomeArquivo;
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

    @Override
    public String getLocalArquivo() {
        return "xhmls"+File.separator;
    }
    

}
