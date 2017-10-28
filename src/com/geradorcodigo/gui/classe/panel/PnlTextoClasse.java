/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.gui.classe.panel;

import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author T01BRQ0067
 */
public class PnlTextoClasse extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextArea jTextArea1;
    private JScrollPane jScrollPane1;
    
    public PnlTextoClasse(String texto) {
        jTextArea1 = new JTextArea();
        jScrollPane1 = new JScrollPane();
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);
        setText(texto);
        //jTextArea1.setBounds(0, 0, width, height-200);
        this.setLayout(new java.awt.GridLayout(1, 1));
//        this.add(jTextArea1);
        this.add(jScrollPane1);
    }
    
    private void setText(String valor){
        Point orig = this.jScrollPane1.getViewport().getViewPosition();
        jTextArea1.setText(valor);
        SwingUtilities.invokeLater(new LaterUpdater(orig));
         repaint();
    }
    
    class LaterUpdater implements Runnable {
      private Point o;
      public LaterUpdater(Point o) {
         this.o = o;
      }
        @Override
      public void run() {
         jScrollPane1.getViewport().setViewPosition(o);
      }
   } 
    
    public void atualisaTexto(String texto){
        setText(texto);
    }
}
