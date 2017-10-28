/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author T01BRQ0067
 */
public abstract class ActionListenerLoadBar implements ActionListener {
    private ActionEvent evt;
    private Thread thread;
    
    public abstract void actionPerformedLoad(ActionEvent evt);
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        this.evt=evt;
        runnable();
    }
    
    private void runnable(){
        if(thread!=null && thread.isAlive()){
            return;
        }
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                actionPerformedLoad(evt);
            }
        });
        thread.start();
    }
}
