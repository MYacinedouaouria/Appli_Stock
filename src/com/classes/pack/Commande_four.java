package com.classes.pack;

import java.sql.Date;

public class Commande_four {
	//mes attributs
	private int id_com;
	private Date date;
	private int id_four;
        private int id_pro;
	private String nom_four;
	private String ville;
        private String entreprise;
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	private String adresse;
	private String  tel_four;
	private String nom_produit;
	private int qte_com;
	
	//constructeurs anec parametres
	public Commande_four(){}

    public Commande_four(int id_com, Date date, int id_four,int id_pro, String nom_produit, int qte_com) {
        this.id_com = id_com;
        this.date = date;
        this.id_four = id_four;
        this.id_pro=id_pro;
        this.nom_produit = nom_produit;
        this.qte_com = qte_com;
    }
	
	
	//getters and setters
	public int getId_com() {
		return id_com;
	}
	public void setId_com(int id_com) {
		this.id_com = id_com;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pror(int id_pro) {
		this.id_pro = id_pro;
	}
        
        public int getId_four() {
		return id_four;
	}
	public void setId_four(int id_four) {
		this.id_four = id_four;
	}
	public String getNom_four() {
		return nom_four;
	}
	public void setNom_four(String nom_four) {
		this.nom_four = nom_four;
	}
	public String getEntreprises() {
		return entreprise;
	}
	public void setEntreprises(String entreprises) {
		this.entreprise = entreprises;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel_four() {
		return tel_four;
	}
	public void setTel_four(String tel_four) {
		this.tel_four = tel_four;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public int getQte_com() {
		return qte_com;
	}
	public void setQte_com(int qte_com) {
		this.qte_com = qte_com;
	}
	
	
	
	
	
}