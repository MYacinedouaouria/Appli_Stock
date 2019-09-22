package com.classes.pack;

import java.sql.Date;

public class Depense {
	private int numero_dep;
	private String type_dep;
	private String nature;
	private float montant;
	private Date date_dep;
        private String login_user;
        
        
	
	public Depense(){}
	public Depense( String type_dep, String nature,
			float montant, Date date_dep,String login) {
		super();
		
		this.type_dep = type_dep;
		this.nature = nature;
		this.montant = montant;
		this.date_dep = date_dep;
                this.login_user=login;
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

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }
        
    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }
	
	 
}
