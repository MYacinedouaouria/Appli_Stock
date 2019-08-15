package com.classes.pack;

public class Client {
		//attributs
	private int id_client;
	private String nom_client;
	private String Addresse;
        private String Telephone;
        private String ville;
        
        //constructeurs par defauld
        public Client(){}

    public Client(int id_client, String nom_client, String Addresse, String Telephone, String ville) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.Addresse = Addresse;
        this.Telephone = Telephone;
        this.ville = ville;
        
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String Addresse) {
        this.Addresse = Addresse;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
        
	
	
	
        
	
}
