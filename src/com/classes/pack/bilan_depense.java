/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class bilan_depense {
    private String date1;
    private String date2;
    private String periode;
   
    String type;
    String nature;
    Date date_dep;
    Float montant;
    String statut_vendeur;
    String nom_vendeur;
    private float total_final;
   
    
    public List<bilan_depense> liste_vente;

   
    public bilan_depense(){}

    public bilan_depense(String type, String nature, Date date_dep, Float montant,String statut,String nom) {
        this.type = type;
        this.nature = nature;
        this.date_dep = date_dep;
        this.montant = montant;
        this.statut_vendeur=statut;
        this.nom_vendeur=nom;
        
    }

    public String getStatut_vendeur() {
        return statut_vendeur;
    }

    public void setStatut_vendeur(String statut_vendeur) {
        this.statut_vendeur = statut_vendeur;
    }

    public String getNom_vendeur() {
        return nom_vendeur;
    }

    public void setNom_vendeur(String nom_vendeur) {
        this.nom_vendeur = nom_vendeur;
    }

  

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }
    
    

    public bilan_depense(String periode) {
        this.periode = periode;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    
    
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
    //surchage de la methode periode pour des intervalls dates
    public void setPeriode(String date1,String date2) {
        this.date1= date1;
        this.date2=date2;
    }


    public float getTotal_final() {
        return total_final;
    }

    public void setTotal_final(float total_final) {
        this.total_final = total_final;
    }

    public List<bilan_depense> getListe_vente() {
        return liste_vente;
    }

    
    
    
    //autres
    public void recup_date() throws ParseException{
        String date;
        String curDate=recup_date_du_jour(new Date());
        if(this.periode=="jour"){
              
                    this.date1 = curDate;
                    this.date2=curDate;
        }
        else if(this.periode=="semaine"){
                    this.date2=curDate;
                     Date actuelle=new Date();
                     actuelle.setDate(actuelle.getDate()-6);
                     this.date1=recup_date_du_jour(actuelle);
                    
             //date="04/03/2018";
        }
        //pour le mois
        else {
                     this.date2=curDate;
                     Date actuelle=new Date();
                     actuelle.setMonth(actuelle.getMonth()-1);
                     this.date1=recup_date_du_jour(actuelle);
                     System.out.println(this.date2);
                     System.out.println(this.date1);
                     
        }
     
    }
    
SingletonConnecction sg=new SingletonConnecction();
     Connection co=sg.getConnexion();
//methode 
    //JOURNAL DES VENTES
  public  void   bilan_dep(String filtrage) throws SQLException, ParseException{
     
     List<bilan_depense> lv=new ArrayList<bilan_depense>();
		bilan_depense jv=null;
     
     try {
             PreparedStatement ps;
                if(filtrage!="tous"){
                    ps=co.prepareStatement("SELECT type_depense, nature,montant,date_dep,u.TYPE,u.NOM from depense as d,admin as u where d.login=u.login and date_dep BETWEEN ? AND ?");
                     ps.setString(1,this.getDate1());
                     ps.setString(2, this.getDate2());
                }
                else{
                     ps=co.prepareStatement("SELECT type_depense, nature,montant,date_dep,u.TYPE,u.NOM from depense as d,admin as u where d.login=u.login");
                }
                 
         
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				jv=new bilan_depense(rs.getString("type_depense"),rs.getString("nature"),rs.getDate("date_dep"), rs.getFloat("montant"),rs.getString("u.TYPE"),rs.getString("u.NOM"));
                                lv.add(jv);
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch blocku
			e.printStackTrace();
		}
     
     
     this.liste_vente=lv;
}
   
   
      //total_vente
    
    public void total_vente(){
        float total=0;
        for(int i=0;i<this.liste_vente.size();i++){
                total=total+this.liste_vente.get(i).getMontant();
        }
       this.total_final=total;
    }
    //recuperation de la dzate automatique du systeme
     public String recup_date_du_jour(Date actuelle){
        
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(actuelle);
                   
                      
                    return date;
        }
}
