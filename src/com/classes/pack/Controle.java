/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes.pack;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class Controle {
    
   public static boolean verification_textfield(JTextField[] to){
           for(int i=0;i<to.length;i++){
               
                    if(to[i].getText().isEmpty()){
                        
                        return false;
               }
           } 
         return true;
    }
      public static boolean verification_formatedfields(JFormattedTextField[] to){
           for(int i=0;i<to.length;i++){
               
                    if(to[i].getText().isEmpty()){
                        return false;
               }
           } 
         return true;
    }
}
