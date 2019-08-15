/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphisme.pack;

import com.classes.pack.Utilisateur;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface role_acteur {
  
    boolean ajouter_user(Utilisateur u);
    boolean modifier_user(Utilisateur u);
    boolean supprimer_user(Utilisateur u);
    List<Utilisateur> rechercher(String type,String Action);
   // Utilisateur rechercher_user(String type,String password);
     public  Utilisateur connection(String login,String password);
}
