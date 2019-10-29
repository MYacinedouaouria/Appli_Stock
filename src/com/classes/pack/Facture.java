/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes.pack;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Facture {
    private int num_fac;
    private int id_client;
    private String nom_client;
    private Date date_fac;
    private float total;
    private String login;
    private String statut_vendeur;
    private String nom_vendeur;

    public Facture(int num_fac, String nom_client, Date date_fac, float total,String statut,String nom) {
        this.num_fac = num_fac;
        this.nom_client = nom_client;
        this.date_fac = date_fac;
        this.statut_vendeur=statut;
        this.nom_vendeur=nom;
        this.total = total;
       
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStatut_vendeur() {
        return statut_vendeur;
    }

    public void setStatut_vendeur(String statut_vendeur) {
        this.statut_vendeur = statut_vendeur;
    }

    public Facture(int id_client, Date date_fac, float total,String login) {
        this.id_client = id_client;
        this.date_fac = date_fac;
        this.total = total;
        this.login=login;
    }
    
    public Facture() {
    }

    public int getNum_fac() {
        return num_fac;
    }

    public String getNom_vendeur() {
        return nom_vendeur;
    }

    public void setNom_vendeur(String nom_vendeur) {
        this.nom_vendeur = nom_vendeur;
    }

    public void setNum_fac(int num_fac) {
        this.num_fac = num_fac;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDate_fac() {
        return date_fac;
    }

    public void setDate_fac(Date date_fac) {
        this.date_fac = date_fac;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }
    
    
    
    
}
