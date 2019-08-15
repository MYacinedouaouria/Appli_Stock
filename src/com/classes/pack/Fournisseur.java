package com.classes.pack;

public class Fournisseur {

		int id_four;
		private String nom_four;
		private String add_four;
		private String entreprise;
		private String tel_four;
		private String ville_four;
		//constructeurs
		public Fournisseur(){}
		public Fournisseur(int id_four, String nom_four, String add_four,
			 String tel_four,String ville) {
			super();
			this.id_four = id_four;
			this.nom_four = nom_four;
			this.add_four = add_four;
			
			this.tel_four = tel_four;
			this.ville_four=ville;
		}
		public String getVille_four() {
			return ville_four;
		}
		public void setVille_four(String ville_four) {
			this.ville_four = ville_four;
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
		public String getAdd_four() {
			return add_four;
		}
		public void setAdd_four(String add_four) {
			this.add_four = add_four;
		}
		public String getEntreprise() {
			return entreprise;
		}
		public void setEntreprise(String entreprise) {
			this.entreprise = entreprise;
		}
		public String getTel_four() {
			return tel_four;
		}
		public void setTel_four(String tel_four) {
			this.tel_four = tel_four;
		}
		public Fournisseur(int id_livreur, String nom_livreur) {
			super();
			this.id_four = id_livreur;
			this.nom_four = nom_livreur;
		}
		
		//getters and setters
		public int getId_livreur() {
			return id_four;
		}
		public void setId_livreur(int id_livreur) {
			this.id_four = id_livreur;
		}
		public String getNom_livreur() {
			return nom_four;
		}
		public void setNom_livreur(String nom_livreur) {
			this.nom_four = nom_livreur;
		}
		public String getAddresse() {
			return add_four;
		}
		public void setAddresse(String addresse) {
			this.add_four = addresse;
		}
		
		
		
		
}
