/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vue.view;

import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author zonne de travaille
 */
public class voir_histogramme extends JDialog{

    public voir_histogramme(Frame owner, boolean modal) {
        super(owner,"TABLEAU DE STATISTIQUE", modal);
        this.setContentPane(new histograme());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400,400);
    }

   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }
    
}
