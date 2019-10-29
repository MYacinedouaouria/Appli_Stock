/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes.pack;

/**
 *
 * @author DELL
 */
public class Utilisateur {
    
    
    private String login;
    public String password;
    public String type;
    public String nom;
    //constructeurs

    public Utilisateur(String login, String password, String type,String nom) {
        this.login = login;
        this.password = password;
        this.type = type;
        this.nom=nom;
    }

    public Utilisateur(){
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
