package com.graphisme.pack;

import com.classes.pack.Client;
import java.util.List;

import com.classes.pack.Commande_cli;
import com.classes.pack.Commande_four;
import com.classes.pack.Depense;
import com.classes.pack.Facture;
import com.classes.pack.Fournisseur;
import com.classes.pack.Produit;
import com.classes.pack.stat_histogramme;


public interface Admin {
    
       
	public int recuperation_idpro(String nom);
        
	void update_quantite(int id_pro, int qte,String action);
	
//differens traitements sut le produit
        //cette methode sea associe à import des donnees via un fichier excel
        void ajouter_liste_produit(List<Produit> lp);
	boolean ajouter_produit(Produit p);
	//modification du produit
	boolean modifier_produit(Produit p);
		void modifier_prix(int id_produit,float prix);
		void modifier_nom(int id_produit, String new_name);
		boolean supprimer_produi(Produit p);
	void affiche_info(Produit p);
	//rechercher un produit
	
	//ancienne version
	//boolean produit_existe(int id,String nom);
	boolean produit_existe(String nom);
        boolean quantite_suffisante(String noms,int qtes);
        int recup_quantite_stock(String nom);
        
	Produit rechercher_Produit_code(int id_produit);
	List<Produit> rechercher_Produit(String type,String val);
	List<Produit> rechercher_Produit_nom(String nom);
	
        //recuperation de la liste de tout les categories ou des rayons
        //le choix est soit la categorie soit le rayon
        String[] list_categorie_rayon(String choix);
	//etat des stocks de prosuit


	List<Produit> affiche_stock(String type);
		// ici le type peuy etre "tous","null", "bas"
	
        //traitement sur les categories et les rauons
        public boolean ajouter_categorie(String nom);
        
        
//differents traitement sur le fournisseur
		boolean ajouter_fournisseur(Fournisseur f);
		boolean modifier_fournisseur(Fournisseur f);
		boolean supprimer_fournisseur(Fournisseur f);
		Fournisseur rechercher_four_code(int id_four);
		List<Fournisseur> rechercher_four_chaine(String ville,String action);
		List<Fournisseur> affiche_fournisseur();
//differents traitement sur les commandes des clients
		void ajouter_commande(Commande_cli cl);
                void ajouter_listcom(List<Commande_cli> lc);
		void ajouter_listcom(List<Commande_cli> lc,Facture f);
		void supprimer_com_client(Commande_cli co);
		void modifier_com_client(Commande_cli cl);
		Commande_cli recherche_com_client_code(int id_com);
		List<Commande_cli> recherche_com_client_date(String Date);
		List<Commande_cli> recherche_com_client(int id_fac);
		List<Commande_cli> affiche_com_cli();
//differents traitements sur les commeades des fournisseurs
		boolean ajouter_com_four(Commande_four cf);
		boolean suppimer_com_four(Commande_four cf);
		boolean modifier_com_four(Commande_four cd);
		List<Commande_four> affiche_com_four();
                List<Commande_four> recherche_com_for(int id_com);
                void ajouter_listcom_four(List<Commande_four> lc);
// differents traitements sur la gestion des depenses
		boolean ajouter_dep(Depense dep);
		boolean supprimer_dep(Depense dep);
		boolean modifier_dep(Depense dep);
		List<Depense> affiche_dep();
		//recuperer les quantites des produits selon leur niveau(bas,nil,eleve)
		int quantite_stock(String niveau);
                
                
                //differents traitement sur les clients
                boolean ajouter_client(Client c);
                boolean modifier_client(Client c);
                boolean supprimer_client(Client c);
               Client rechercher_client(int id_cli);
               List<Client> rechercher_liste_client(String valeur ,String action);
               boolean client_existe(int code);
               
               //gestion des factures
               boolean ajouter_facture(Facture f);
               boolean supprimer_facture(Facture f);
               List<Facture> list_facture();
               List<Facture> list_facture(int num_fac);
               List<Facture> list_facture(String type,String valeur);
              
               //methode pour consulter le bilan a partir de histogramme
               public List<stat_histogramme> bilan(String critere);
}

//Cher monsieur fran vous avez du pain sur  la planche car vous 
//avez plus de 30 methodes � coder
//journee du 21/02/2019 : plus que 4  methodes restantes
//courage frank!!!!!
	