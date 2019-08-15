package com.classes.pack;

public class Categorie {
	
	private int id_categorie;
	private String nom_categorie;
	//constructeurs
	public Categorie(int id_categorie, String nom_categorie) {
		super();
		this.id_categorie = id_categorie;
		this.nom_categorie = nom_categorie;
	}
	public Categorie(int id_categorie) {
		super();
		this.id_categorie = id_categorie;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public String getNom_categorie() {
		return nom_categorie;
	}
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	
	//getters ans setters
	
	

}
