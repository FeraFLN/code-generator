/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.gui.classe.panel;

import com.geradorcodigo.gui.FramePrincipal;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author T01BRQ0067
 */
public class LoadPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JProgressBar bar;
    private final int HIGHT_BAR = 16;
    private final int WIDTH_BAR = 340;
    private Container myContainer;
    private JLabel lblInformacao;
    private static LoadPanel l = null;
    @SuppressWarnings("unchecked")
    private final List<Class<? extends Component>> listComp = new ArrayList<Class<? extends Component>> ( Arrays.asList( JTabbedPane.class, 
                                                                  JPanel.class,JScrollPane.class));


    private LoadPanel() {
    }

    public static void showLoadBar(Container container) {
        if (l == null) {
            l = new LoadPanel();
            l.setOpaque(false);
            l.setLayout(null);
        }
        if (!Arrays.asList(container.getComponents()).contains(l)) {
            container.add(l,0);
        }
        l.myContainer = container;
        
        l.setBounds(0, 0, l.myContainer.getBounds().width, l.myContainer.getBounds().height);
        l.createLabel();
        l.createBar();
        l.setEnabledCampos(false);
        l.setVisible(true);

    }

    public static void disposeLoadBar() {
        if (l == null) {
            return;
        }
        l.setEnabledCampos(true);
        l.setVisible(false);
        setTextLoadBar("");
//        if (Arrays.asList(l.myContainer.getComponents()).contains(l)) {
//            l.myContainer.remove(l);
//        }
        l.myContainer.repaint();
    }
    
    public static void setTextLoadBar(String texto) {
        if(l==null){
            return;
        }
        l.lblInformacao.setText(texto);
        l.myContainer.repaint();
    }

    private void createLabel() {
        if (lblInformacao != null) {
            return;
        }
        lblInformacao = new JLabel();
        lblInformacao.setFont(FramePrincipal.DEFAULT_FONT);
        lblInformacao.setBounds(valorCetralizadoVertical(), valorCetralizadoHorizontal() + HIGHT_BAR, WIDTH_BAR, 24);
        lblInformacao.setVerticalAlignment(JLabel.CENTER);
        lblInformacao.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblInformacao);
    }

    private void createBar() {
        if (bar != null) {
            return;
        }
        bar = new JProgressBar();
        bar.setIndeterminate(true);
        bar.setBounds(valorCetralizadoVertical(), valorCetralizadoHorizontal(), WIDTH_BAR, HIGHT_BAR);
        this.add(bar);
    }

    private int valorCetralizadoVertical() {
        return (getBounds().height / 2) - (HIGHT_BAR / 2);
    }

    private int valorCetralizadoHorizontal() {
        return (getBounds().width / 2) - (WIDTH_BAR / 2);
    }

    private void setEnabledCampos(boolean valor) {
        setEnabledCampos(valor, myContainer);
    }

    private void setEnabledCampos(boolean valor, Container container) {
        for (Component component : container.getComponents()) {
            if (component.equals(this)) {
                continue;
            }
            Class componentClass = getObjectInList(component.getClass());
//            if (!listComp.contains(component.getClass()) && !listComp.contains(component.getClass().getSuperclass())) {
            if (componentClass==null) {
                component.setEnabled(valor);
            } else {
                component.setEnabled(valor);
                if (componentClass.equals(JScrollPane.class)) {
                    setEnabledCampos(valor, ((JScrollPane) component).getViewport());

                }
                setEnabledCampos(valor, (Container) component);
            }
        }
    }
    
    private Class<? extends Object> getObjectInList(Class<? extends Object> o){
        if(listComp.contains(o)){
            return o;
        }else if(!o.equals(Object.class )){
            return getObjectInList(o.getSuperclass());
        }else{
            return null;
        }
    }
}
