package com.classes.pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Commande_cli {
	private  int id_command=0;
	private int id_client;
	private int id_pro;
	private int id_fac;
	private Date date_commande;
	private String nom_produit;
	private int qte_produit;
	private float prix_uni;
	private float total;
	
	public Commande_cli(){
		this.id_client=1;
	}
	//consteurs avec parameteres
	
	   public Commande_cli(int id_fac, int id_pro,
            String nom_produit, int qte_produit, float prix_uni) {
        super();
        this.id_command = this.id_command + 1;

        this.id_pro = id_pro;
        this.id_fac = id_fac;

        this.nom_produit = nom_produit;

        this.qte_produit = qte_produit;
        this.prix_uni = prix_uni;
        this.total = prix_uni * qte_produit;

    }
	
	

	public Commande_cli(int id_fac,int id_pro,
			int qte_produit, float prix_uni) {
		super();
		this.id_pro = id_pro;
		this.id_fac = id_fac;
		this.qte_produit = qte_produit;
		this.prix_uni = prix_uni;
		this.total = prix_uni*qte_produit;
	}

	public  int getId_command() {
		return id_command;
	}

	public  void setId_command(int id_command) {
		this.id_command = id_command;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_pro() {
		return id_pro;
	}

	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}

	public int getId_fac() {
		return id_fac;
	}

	public void setId_fac(int id_fac) {
		this.id_fac = id_fac;
	}

	
	public String getNom_produit() {
		return nom_produit;
	}

	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}

	public int getQte_produit() {
		return qte_produit;
	}

	public void setQte_produit(int qte_produit) {
		this.qte_produit = qte_produit;
	}

	public float getPrix_uni() {
		return prix_uni;
	}

	public void setPrix_uni(float prix_uni) {
		this.prix_uni = prix_uni;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	
	


}
