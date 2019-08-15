package com.classes.pack;

public class Rayon {
	
	//attributs
	private int num_rayon;
	private String nom_rayon;
	//constructeurs
	
	public Rayon(int num_rayon, String nom_rayon) {
		super();
		this.num_rayon = num_rayon;
		this.nom_rayon = nom_rayon;
	}

	public Rayon(int num_rayon) {
		super();
		this.num_rayon = num_rayon;
	}

	public int getNum_rayon() {
		return num_rayon;
	}

	public void setNum_rayon(int num_rayon) {
		this.num_rayon = num_rayon;
	}

	public String getNom_rayon() {
		return nom_rayon;
	}

	public void setNom_rayon(String nom_rayon) {
		this.nom_rayon = nom_rayon;
	}
	
	// getters ans setters
	
	
}
