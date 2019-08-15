package com.classes.pack;

public class Depense {
	private int numero_dep;
	private String type_dep;
	private String nature;
	private float montant;
	private String date_dep;
	
	public Depense(){}
	public Depense(int numero_dep, String type_dep, String nature,
			float montant, String date_dep) {
		super();
		this.numero_dep = numero_dep;
		this.type_dep = type_dep;
		this.nature = nature;
		this.montant = montant;
		this.date_dep = date_dep;
	}
	public int getNumero_dep() {
		return numero_dep;
	}
	public void setNumero_dep(int numero_dep) {
		this.numero_dep = numero_dep;
	}
	public String getType_dep() {
		return type_dep;
	}
	public void setType_dep(String type_dep) {
		this.type_dep = type_dep;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getDate_dep() {
		return date_dep;
	}
	public void setDate_dep(String date_dep) {
		this.date_dep = date_dep;
	}
	 
}
