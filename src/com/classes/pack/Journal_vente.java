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
public class Journal_vente {
    private String date1;
    private String date2;
    private String periode;
    private int id_pro;
    private String categorie;
    private String rayon;
    private String nom_pro;
    private int quantite_vendues;
    private float total_vendu;
    private float total_final;
   
    
    public List<Journal_vente> liste_vente;

    public Journal_vente(int id_pro, String nom_pro, String cate,int quantite_vendues, float total_vendu) {
        this.id_pro = id_pro;
        this.nom_pro = nom_pro;
        this.quantite_vendues = quantite_vendues;
        this.total_vendu = total_vendu;
        this.categorie=cate;
        
    }
    public Journal_vente(){}
    
    public String getCategorie() {    
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getRayon() {
        return rayon;
    }

    //getters and setters
    
    public void setRayon(String rayon) {    
        this.rayon = rayon;
    }

    public Journal_vente(String periode) {
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

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getNom_pro() {
        return nom_pro;
    }

    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }

    public int getQuantite_vendues() {
        return quantite_vendues;
    }

    public void setQuantite_vendues(int quantite_vendues) {
        this.quantite_vendues = quantite_vendues;
    }

    public float getTotal_vendu() {
        return total_vendu;
    }

    public void setTotal_vendu(float total_vendu) {
        this.total_vendu = total_vendu;
    }

    public float getTotal_final() {
        return total_final;
    }

    public void setTotal_final(float total_final) {
        this.total_final = total_final;
    }

    public List<Journal_vente> getListe_vente() {
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
  public  void   vente_date(String filtrage) throws SQLException, ParseException{
     
     List<Journal_vente> lv=new ArrayList<Journal_vente>();
		Journal_vente jv=null;
     
     try {
             PreparedStatement ps;
                if(filtrage!="tous"){
                    ps=co.prepareStatement("SELECT c.id_pro,p.nom_pro,p.nom_categorie, SUM(c.quantite) as qv,SUM(c.pri_uni*c.quantite) as tv from produit  as p,commande_cli as c,facture as f  where p.id_pro=c.id_pro and c.id_fac=f.id_fac AND f.date_fac BETWEEN ? AND ?  group by p.id_pro order by p.nom_pro asc");
                     ps.setString(1,this.getDate1());
                     ps.setString(2, this.getDate2());
                }
                else{
                     ps=co.prepareStatement("SELECT c.id_pro,p.nom_pro,p.nom_categorie, SUM(c.quantite) as qv,SUM(c.pri_uni*c.quantite) as tv from produit  as p,commande_cli as c,facture as f where p.id_pro=c.id_pro and c.id_fac=f.id_fac group by p.id_pro order by p.nom_pro asc");
                }
                 
         
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				jv=new Journal_vente(rs.getInt("c.id_pro"),rs.getString("p.nom_pro"),rs.getString("p.nom_categorie"), rs.getInt("qv"), rs.getFloat("tv"));
                                lv.add(jv);
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
     
     this.liste_vente=lv;
}
   //JOURNAL DES VENTES
  public  void   vente_date(String filtrage,String type) throws SQLException, ParseException{
     
     List<Journal_vente> lv=new ArrayList<Journal_vente>();
		Journal_vente jv=null;
     
     try {
             PreparedStatement ps;
                if(filtrage!="tous"){
                    ps=co.prepareStatement("SELECT c.id_pro,p.nom_pro,p.nom_categorie, SUM(c.quantite) as qv,SUM(c.prix_achat*c.quantite) as tv from produit  as p,livraison as c  where p.id_pro=c.id_pro AND c.date_com BETWEEN ? AND ?  group by p.id_pro order by qv asc");
                     ps.setString(1,this.getDate1());
                     ps.setString(2, this.getDate2());
                }
                else{
                     ps=co.prepareStatement("SELECT c.id_pro,p.nom_pro,p.nom_categorie, SUM(c.quantite) as qv,SUM(c.prix_achat*c.quantite) as tv from produit  as p,livraison as c where p.id_pro=c.id_pro  group by p.id_pro order by qv asc");
                }
                 
         
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				jv=new Journal_vente(rs.getInt("c.id_pro"),rs.getString("p.nom_pro"),rs.getString("p.nom_categorie"), rs.getInt("qv"), rs.getFloat("tv"));
                                lv.add(jv);
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
     
     this.liste_vente=lv;
}
 
   
      //total_vente
    
    public void total_vente(){
        float total=0;
        for(int i=0;i<this.liste_vente.size();i++){
                total=total+this.liste_vente.get(i).getTotal_vendu();
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
