/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.gui.classe.panel;

import com.geradorcodigo.domain.java.ObjetoJava;
import com.geradorcodigo.gui.FramePrincipal;
import com.geradorcodigo.util.Util;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author T01BRQ0067
 */
public class PnlClasse extends JPanel implements PanelFrame{

    private static final long serialVersionUID = 1L;
    private Rectangle PANEL_NORTE;
    private Rectangle PANEL_SUL;
    private int percentPanelNorte = 20;
    private ObjetoJava objetoJava;
    private JPanel pnlNorte;
    private PnlTextoClasse classe;

    public PnlClasse(ObjetoJava objetoJava, int width, int height) {
        this.setSize(width, height);
        this.objetoJava = objetoJava;
        this.pnlNorte = new JPanel(null);
        panels(width, height);
        classe = new PnlTextoClasse(objetoJava.toString());
        classe.setBounds(PANEL_SUL);
        createPanelNorte();
        this.add(classe);
        this.add(pnlNorte);
        this.setLayout(null);
    }

    public ObjetoJava getObjetoJava() {
        return objetoJava;
    }

    private void createPanelNorte() {
        createCampo("Package:", objetoJava.getPkg(), true, 10, 10, 250);
        createCampo("Nome:", objetoJava.getNome(), false, 10, 35, 250);
        createCampo("Acessibilidade:", objetoJava.getAcessibilidade().getValue(), false, 10, 60, 250);
    }

    private void createCampo(String label, String fieldString, boolean editabled, int x, int y, int widthField) {
//        int x = 10;
//        int y = 10;
        JLabel jl = new JLabel(label);//"Package:");
        final JTextField field = new JTextField(fieldString);//objetoJava.getPkg());
        jl.setBounds(x, y, 60, FramePrincipal.DEFAULT_HEIGHT);
        jl.setFont(FramePrincipal.DEFAULT_FONT);
        jl.setHorizontalAlignment(JLabel.RIGHT);
        jl.setVerticalAlignment(JLabel.CENTER);
        field.setBounds(x + jl.getSize().width, y, widthField, FramePrincipal.DEFAULT_HEIGHT);
        field.setFont(FramePrincipal.DEFAULT_FONT);
        field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                objetoJava.setPkg(field.getText());
                classe.atualisaTexto(objetoJava.toString());
                jTextField1KeyReleased(evt);
            }
        });
        field.setEditable(editabled);
        pnlNorte.add(jl);
        pnlNorte.add(field);

    }

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {
        
//        this.repaint();
    }

    private void panels(int width, int height) {
//        int maxHeight = height;
        int norteHeigth = ((percentPanelNorte * height) / 100);
        PANEL_NORTE = new Rectangle(0, 0, width, norteHeigth);
        PANEL_SUL = new Rectangle(0, norteHeigth, width, height - norteHeigth - 70);
        pnlNorte.setBounds(PANEL_NORTE);
    }

    @Override
    public String getNomeArquivo() {
        return objetoJava.getNome()+".java";
    }

    @Override
    public String getTexto() {
        return objetoJava.toString();
    }

    @Override
    public String getLocalArquivo() {
        return Util.incluiFileSeparator(objetoJava.getPkg().trim().replace(".", File.separator));
    }
}
