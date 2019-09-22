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
public class stat_histogramme {
    private String date;
    private float montant_total;

    public stat_histogramme(String date, float montant) {
        this.date = date;
        this.montant_total = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMontant() {
        return montant_total;
    }

    public void setMontant(float montant) {
        this.montant_total = montant;
    }
    
}
