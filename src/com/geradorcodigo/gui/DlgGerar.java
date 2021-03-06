/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgGerar.java
 *
 * Created on 23/07/2015, 09:30:32
 */
package com.geradorcodigo.gui;

/**
 *
 * @author T01BRQ0067
 */
public class DlgGerar extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private boolean OK=false;

    public String getColunaDescricao() {
        return txtDescricaoColuna.getText();
    }

    public String getColunaId() {
        return txtIdColuna.getText();
    }

    public boolean isConsultaIdDesc() {
        return chbIdAutoComplete.isSelected();
    }

    public String getNomeDesenvolvedor() {
        return txtNomeDesenvolvedor.getText();
    }

    public String getOwnerTabela() {
        return txtOwnerTabela.getText();
    }

    public String getTabela() {
        return txtNomeTabela.getText();
    }
    
    public boolean showThis(boolean valor){
        super.setVisible(valor);
        return OK; 
    }
    
    public String getTitulo(){
        return txtTitulo.getText();
    }
    public String getCodAtividade(){
        return txtCodigoAtividade.getText();
    }
    
    public String getPasta(){
        return txtPasta.getText();
    }
    /** Creates new form DlgGerar */
    public DlgGerar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOwnerTabela = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeTabela = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeDesenvolvedor = new javax.swing.JTextField();
        txtIdColuna = new javax.swing.JTextField();
        chbIdAutoComplete = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescricaoColuna = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtPasta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoAtividade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel1.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel1.setText("Owner:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 80, 14);

        txtOwnerTabela.setFont(FramePrincipal.DEFAULT_FONT);
        txtOwnerTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOwnerTabelaActionPerformed(evt);
            }
        });
        jPanel1.add(txtOwnerTabela);
        txtOwnerTabela.setBounds(10, 25, 140, 23);

        jLabel2.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel2.setText("Nome desenvolvedor:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 50, 120, 14);

        txtNomeTabela.setFont(FramePrincipal.DEFAULT_FONT);
        jPanel1.add(txtNomeTabela);
        txtNomeTabela.setBounds(160, 25, 150, 23);

        jLabel3.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel3.setText("Nome tabela:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 10, 110, 14);

        txtNomeDesenvolvedor.setFont(FramePrincipal.DEFAULT_FONT);
        jPanel1.add(txtNomeDesenvolvedor);
        txtNomeDesenvolvedor.setBounds(10, 65, 140, 23);

        txtIdColuna.setFont(FramePrincipal.DEFAULT_FONT);
        txtIdColuna.setEnabled(false);
        jPanel1.add(txtIdColuna);
        txtIdColuna.setBounds(170, 100, 100, 23);

        chbIdAutoComplete.setFont(FramePrincipal.DEFAULT_FONT);
        chbIdAutoComplete.setText("Consulta id e autoComplete?");
        chbIdAutoComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbIdAutoCompleteActionPerformed(evt);
            }
        });
        jPanel1.add(chbIdAutoComplete);
        chbIdAutoComplete.setBounds(10, 100, 170, 23);

        jLabel4.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel4.setText("Coluna id:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 85, 90, 14);

        jLabel5.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel5.setText("Coluna descri��o:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 85, 110, 14);

        txtDescricaoColuna.setFont(FramePrincipal.DEFAULT_FONT);
        txtDescricaoColuna.setEnabled(false);
        jPanel1.add(txtDescricaoColuna);
        txtDescricaoColuna.setBounds(280, 100, 110, 23);

        jLabel6.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel6.setText("Titulo xhtml:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 130, 120, 14);

        txtTitulo.setFont(FramePrincipal.DEFAULT_FONT);
        jPanel1.add(txtTitulo);
        txtTitulo.setBounds(10, 145, 140, 23);

        txtPasta.setFont(FramePrincipal.DEFAULT_FONT);
        jPanel1.add(txtPasta);
        txtPasta.setBounds(160, 145, 140, 23);

        jLabel7.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel7.setText("Pasta xhtml:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(160, 130, 140, 14);

        jLabel8.setFont(FramePrincipal.DEFAULT_FONT);
        jLabel8.setText("Cod. Atividade:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(310, 130, 90, 14);

        txtCodigoAtividade.setFont(FramePrincipal.DEFAULT_FONT);
        jPanel1.add(txtCodigoAtividade);
        txtCodigoAtividade.setBounds(310, 145, 80, 23);

        jButton1.setFont(FramePrincipal.DEFAULT_FONT);
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(FramePrincipal.DEFAULT_FONT);
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-410)/2, (screenSize.height-281)/2, 410, 281);
    }// </editor-fold>//GEN-END:initComponents

private void txtOwnerTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOwnerTabelaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtOwnerTabelaActionPerformed

private void chbIdAutoCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbIdAutoCompleteActionPerformed
        txtDescricaoColuna.setEnabled(chbIdAutoComplete.isSelected());
        txtIdColuna.setEnabled(chbIdAutoComplete.isSelected());
}//GEN-LAST:event_chbIdAutoCompleteActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    OK=true;
    showThis(false);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    OK=false;
    showThis(false);
}//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DlgGerar dialog = new DlgGerar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbIdAutoComplete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigoAtividade;
    private javax.swing.JTextField txtDescricaoColuna;
    private javax.swing.JTextField txtIdColuna;
    private javax.swing.JTextField txtNomeDesenvolvedor;
    private javax.swing.JTextField txtNomeTabela;
    private javax.swing.JTextField txtOwnerTabela;
    private javax.swing.JTextField txtPasta;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
