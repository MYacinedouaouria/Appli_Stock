package com.vue.pack;

/*
 * BlinkingLabel.java  1.0
 * 
 * Copyright (c) 1999 Emmanuel PUYBARET - eTeks.
 * All Rights Reserved.
 *
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
// Classe de label clignotant en utilisant 
// alternativement la couleur par défaut du label 
// et une autre couleur passée au constructeur 
public class BlinkingLabel extends JLabel
{  
  Color firstColor;   // Couleur par défaut du label
  Color secondColor;  // Couleur de clignotement
  Color thirdColor;
  Timer timer;          // Timer déclenchant des tics
 
  // Constructeur 

    public BlinkingLabel(String Text,Color firstColor, Color secondColor, Color thirdColor) {
        super(Text);
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        this.thirdColor = thirdColor;
        // Création et lancement du timer
        timer = createTimer();
        timer.start();
    }
 
  
  // Méthode renvoyant un timer prêt à démarrer
  private Timer createTimer ()
  {
    // Création d'une instance de listener 
    // associée au timer
    ActionListener action = new ActionListener ()
      {
        // Méthode appelée à chaque tic du timer
        public void actionPerformed (ActionEvent event)
        {
          // Inversion de la couleur
          if (getForeground ().equals (firstColor))            
            setForeground (secondColor);
          else if (getForeground().equals(secondColor))
              setForeground(thirdColor);
          else
            setForeground (firstColor);
        }
      };
      
    // Création d'un timer qui génère un tic
    // chaque 500 millième de seconde
    return new Timer (500, action);
  }  
  
}