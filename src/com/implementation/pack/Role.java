package com.implementation.pack;

import com.classes.pack.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.classes.pack.Commande_cli;
import com.classes.pack.Commande_four;
import com.classes.pack.Depense;
import com.classes.pack.Facture;
import com.classes.pack.Fournisseur;
import com.classes.pack.Produit;
import com.classes.pack.SingletonConnecction;
import com.graphisme.pack.Admin;
import com.vue.pack.depense;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Role implements Admin {
        
        SingletonConnecction sg=new SingletonConnecction();
	Connection co=sg.getConnexion();
        
        
         //fonction pour recuperer automatiquement la date du jour de la machine 
        public String recup_date_du_jour(){
        
                    
                    Date actuelle = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String date = dateFormat.format(actuelle);
                    return date;
        }
        
        //recuperation id
        @Override
	public int recuperation_idpro(String nom){
		int id=-1;
                try {
			
			PreparedStatement ps;
			SingletonConnecction sg=new SingletonConnecction();
		
			Connection co=sg.getConnexion();
			ps=co.prepareStatement("select id_pro from PRODUIT where nom_pro=?");
			ps.setString(1, nom);
			ResultSet rs=ps.executeQuery();
			rs.next();
			id=rs.getInt("id_pro");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
			return id;
	}
	
        
    @Override
    public void ajouter_liste_produit(List<Produit> lp) {
        
        for(int i=0;i<lp.size();i++){
            ajouter_produit(lp.get(i));
        
        }
      
    }
        
	@Override
	 //ajout de produit
                public boolean ajouter_produit(Produit p) {
		// TODO Auto-generated method stub
		try {
                    Connection co=SingletonConnecction.getConnexion();
                            
			PreparedStatement ps=co.prepareStatement("insert into PRODUIT(NOM_CATEGORIE,NOM_RAYON,NOM_PRO,PRI_UNI,QUANTITE,stock_alert) value(?,?,?,?,?,?)");
			
			ps.setString(1, p.getId_categorie());
			ps.setString(2, p.getNum_rayon());
			ps.setString(3, p.getNom_produit());
			ps.setInt(5, p.getQuantite());
			ps.setFloat(4, p.getPrix_unitaire());
                        ps.setInt(6, p.getAlert());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                        return false;
			
		}
                        return true;
	}

	@Override
	public boolean modifier_produit(Produit p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("update PRODUIT set NOM_CATEGORIE=?,NOM_RAYON=?,NOM_PRO=?,PRI_UNI=?,QUANTITE=?,stock_alert=? where ID_PRO=?");
			ps.setString(1, p.getId_categorie());
			ps.setString(2, p.getNum_rayon());
			ps.setString(3, p.getNom_produit());
			ps.setInt(5, p.getQuantite());
			ps.setFloat(4, p.getPrix_unitaire());
                        ps.setInt(6, p.getAlert());
                        ps.setInt(7, p.getId_produit());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void modifier_prix(int id_produit, float prix) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("update PRODUIT set PRI_UNI=? where  ID_PRO=?");
			ps.setFloat(1, prix);
			ps.setInt(2, id_produit);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifier_nom(int id_produit, String new_name) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("update PRODUIT set PRI_UNI=? where  ID_PRO=?");
			ps.setString(1, new_name);
			ps.setInt(2, id_produit);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean supprimer_produi(Produit p) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("delete from COMMANDE_CLI where ID_PRO=?" );
			ps.setInt(1, p.getId_produit());
			ps.executeUpdate();
			ps=co.prepareStatement("delete from PRODUIT where ID_PRO=?" );
			ps.setInt(1, p.getId_produit());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void affiche_info(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit rechercher_Produit_code(int id_produit) {
		// TODO Auto-generated method stub
		Produit p=null;
		try {
			
			PreparedStatement ps=co.prepareStatement("select * from PRODUIT where ID_PRO=?");
			ps.setInt(1, id_produit);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
                                p=new Produit();
				p.setId_produit(rs.getInt("ID_PRO"));
				p.setId_categorie(rs.getString("NOM_CATEGORIE"));
				p.setNum_rayon(rs.getString("NOM_RAYON"));
				p.setNom_produit(rs.getString("NOM_PRO"));
				p.setQuantite(rs.getInt("QUANTITE"));
				p.setPrix_unitaire(rs.getFloat("PRI_UNI"));
                                p.setAlert(rs.getInt("stock_alert"));
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(p==null)throw new RuntimeException("pas dE PRODUIT trouver");
		return p;
	}

	@Override
	public List<Produit> rechercher_Produit(String type,String val) {
		// TODO Auto-generated method stub
		List<Produit> lp=new ArrayList<>();
		Produit p=null;
		try {
			PreparedStatement ps;
			if(type=="categorie"){
			 ps=co.prepareStatement("select * from PRODUIT where NOM_CATEGORIE=?");
			ps.setString(1, val);
			}
			else if(type=="nom_produit"){
				 ps=co.prepareStatement("select * from PRODUIT where NOM_PRO=?");
				 ps.setString(1, val);
			
			}
			else{
				 ps=co.prepareStatement("select * from PRODUIT where NOM_RAYON=?");
				ps.setString(1, val);
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p=new Produit();
				p.setId_produit(rs.getInt("ID_PRO"));
				p.setId_categorie(rs.getString("NOM_CATEGORIE"));
				p.setNum_rayon(rs.getString("NOM_RAYON"));
				p.setNom_produit(rs.getString("NOM_PRO"));
				p.setQuantite(rs.getInt("QUANTITE"));
				p.setPrix_unitaire(rs.getFloat("PRI_UNI"));
				lp.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas de PRODUIT trouver");
		return lp;
	}


        @Override
	public List<Produit> rechercher_Produit_nom(String nom) {
		// TODO Auto-generated method stub
                List<Produit> lp=new ArrayList<>();
		Produit p=null;
		try {
			PreparedStatement ps;
			
				 ps=co.prepareStatement("select * from PRODUIT where NOM_PRO=?");
				ps.setString(1, nom);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p=new Produit();
				p.setId_produit(rs.getInt("ID_PRO"));
				p.setId_categorie(rs.getString("NOM_CATEGORIE"));
				p.setNum_rayon(rs.getString("NOM_RAYON"));
				p.setNom_produit(rs.getString("NOM_PRO"));
				p.setQuantite(rs.getInt("QUANTITE"));
				p.setPrix_unitaire(rs.getFloat("PRI_UNI"));
				lp.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas de PRODUIT trouver");
		return lp;
        }
        
	
	@Override
	public List<Produit> affiche_stock(String type) {
		// TODO Auto-generated method stub
		List<Produit> lp=new ArrayList<>();
		Produit p=null;
		try {
			PreparedStatement ps;
			if(type=="bas"){
			 ps=co.prepareStatement("select * from PRODUIT where QUANTITE<=stock_alert and QUANTITE!=0");
			}
			else if(type=="null"){
				 ps=co.prepareStatement("select * from PRODUIT where QUANTITE=0");
				
			}
			else if(type=="tous"){
				ps=co.prepareStatement("select * from PRODUIT");
			}
			else{
				 ps=co.prepareStatement("select * from PRODUIT where QUANTITE>stock_alert");
			}
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
				p=new Produit();
				p.setId_produit(rs.getInt("ID_PRO"));
				p.setId_categorie(rs.getString("NOM_CATEGORIE"));
				p.setNum_rayon(rs.getString("NOM_RAYON"));
				p.setNom_produit(rs.getString("NOM_PRO"));
				p.setQuantite(rs.getInt("QUANTITE"));
				p.setPrix_unitaire(rs.getFloat("PRI_UNI"));
                                p.setAlert(rs.getInt("stock_alert"));
				lp.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp==null)throw new RuntimeException("pas de PRODUIT trouver");
		return lp;
	}

	

	@Override
	public boolean ajouter_fournisseur(Fournisseur p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("insert into FOURNISSEUR(ENTREPRISE,NOM_FOURNISSEUR,ADD_FOURNISSEUR,TEL_FOURNISSEUR,VILLE) value(?,?,?,?,?)");
			ps.setString(1, p.getEntreprise());
			ps.setString(2, p.getNom_four());
			ps.setString(3, p.getAdd_four());
			ps.setString(4, p.getTel_four());
			ps.setString(5, p.getVille_four());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean modifier_fournisseur(Fournisseur p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("update FOURNISSEUR set ENTREPRISE=?, NOM_FOURNISSEUR=?,ADD_FOURNISSEUR=?,TEL_FOURNISSEUR=?,VILLE=? where ID_FOURNISSEUR=?");
			ps.setString(1, p.getEntreprise());
			ps.setString(2, p.getNom_four());
			ps.setString(3, p.getAdd_four());
			ps.setString(4, p.getTel_four());
			ps.setString(5, p.getVille_four());
			ps.setInt(6, p.getId_four());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean supprimer_fournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
                PreparedStatement ps;
		try {
                    //on supprime d'abord toutes les commandes de ce fournisseur
                    ps=co.prepareStatement("delete from LIVRAISON where ID_FOURNISSEUR=?" );
			ps.setInt(1, f.getId_four());
			ps.executeUpdate();
			ps=co.prepareStatement("delete from FOURNISSEUR where ID_FOURNISSEUR=?" );
			ps.setInt(1, f.getId_four());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Fournisseur rechercher_four_code(int id_four) {
		// TODO Auto-generated method stub
		Fournisseur f=null;
		try {
			PreparedStatement ps;
			
			
				 ps=co.prepareStatement("select * from FOURNISSEUR where ID_FOURNISSEUR=?");
				ps.setInt(1, id_four);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				f=new Fournisseur();
				f.setEntreprise(rs.getString("ENTREPRISE"));
				f.setId_four(rs.getInt("ID_FOURNISSEUR"));
				f.setNom_four(rs.getString("NOM_FOURNISSEUR"));
				f.setAdd_four(rs.getString("ADD_FOURNISSEUR"));
				f.setTel_four(rs.getString("TEL_FOURNISSEUR"));
				f.setVille_four(rs.getString("VILLE"));
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(f==null)throw new RuntimeException("pas de FOURNISSEUR trouver trouver");
		return f;
	}

	@Override
	public List<Fournisseur> rechercher_four_chaine(String valeur,String action) {
		// TODO Auto-generated method stub
		List<Fournisseur> lp=new ArrayList<>();
		Fournisseur f=null;
		try {
			PreparedStatement ps;
			
			if(action=="ville")
				 ps=co.prepareStatement("select * from FOURNISSEUR where VILLE=?");
                        else
                            ps=co.prepareStatement("select * from FOURNISSEUR where NOM_FOURNISSEUR=?");
			
                        ps.setString(1, valeur);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				f=new Fournisseur();
				f.setEntreprise(rs.getString("ENTREPRISE"));
				f.setId_four(rs.getInt("ID_FOURNISSEUR"));
				f.setNom_four(rs.getString("NOM_FOURNISSEUR"));
				f.setAdd_four(rs.getString("ADD_FOURNISSEUR"));
				f.setTel_four(rs.getString("TEL_FOURNISSEUR"));
				f.setVille_four(rs.getString("VILLE"));
				lp.add(f);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas de FOURNISSEUR trouver");
		return lp;
	}

	@Override
	public List<Fournisseur> affiche_fournisseur() {
		// TODO Auto-generated method stub
		List<Fournisseur> lp=new ArrayList<>();
		Fournisseur f=null;
		try {
			PreparedStatement ps;
			
			
				 ps=co.prepareStatement("select * from FOURNISSEUR");
				
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				f=new Fournisseur();
				f.setEntreprise(rs.getString("ENTREPRISE"));
				f.setId_four(rs.getInt("ID_FOURNISSEUR"));
				f.setNom_four(rs.getString("NOM_FOURNISSEUR"));
				f.setAdd_four(rs.getString("ADD_FOURNISSEUR"));
				f.setTel_four(rs.getString("TEL_FOURNISSEUR"));
				f.setVille_four(rs.getString("VILLE"));
				lp.add(f);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas de fournisseur  trouver");
		return lp;
	}

	/*@Override
	public boolean ajouter_com_client(Commande_cli p) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
	if(produit_existe(p.getId_pro(), p.getNom_produit())){	
	try {
	  
		ps=co.prepareStatement("insert into commande value(NULL,?,?,?,?,?)");
		//ps.setInt(1, p.getId_commande());
		ps.setString(1, p.getDate_commande());
		ps.setString(2, p.getNom_produit());
		ps.setFloat(3, p.getPrix_uni());
		ps.setInt(4, p.getQte_produit());
		ps.setFloat(5, p.getTotal());
		ps.executeUpdate();
		ps.close();
		
		
		ps=co.prepareStatement("insert into produit_commande value(?,NULL)");
		ps.setInt(1, p.getId_pro());
		//ps.setInt(2, p.getId_commande());
		
		this.update_quantite(p.getId_pro(), p.getQte_produit(),"remove");
		
		ps.executeUpdate();
		ps.close();
		
	  
	  
	
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
		}
	// le produit en question existe
		return true;
		
	}
	else{
		//ie le produit en question n'eciste pas pout qu'on puisse le rechercher
		return false;
	}
	
		
	}

	@Override
	public void modifier_com_cliente(Commande_cli co) {
		// TODO Auto-generated method stub
		
	}*/

	

	@Override
	public boolean  ajouter_com_four(Commande_four p) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
                p.setId_pror(this.recuperation_idpro(p.getNom_produit()));
		try {
			
			ps=co.prepareStatement("insert into LIVRAISON value(NULL,?,?,?,?)");
			
			ps.setInt(1, p.getId_four());
			ps.setInt(2, p.getId_pro());
			ps.setDate(3, p.getDate());
			ps.setFloat(4, p.getQte_com());
			
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("ajout reussi");
				update_quantite(p.getId_pro(), p.getQte_com(), "add");
			}
			else{
				System.out.println("echec ajout");
                                
			}
			ps.close();
                        
		return true;
                
		} catch (SQLException e) {
 			e.printStackTrace();
                        return false;
                        
		}
	}

	@Override
	public boolean suppimer_com_four(Commande_four p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("delete from LIVRAISON where id_com=?" );
			ps.setInt(1, p.getId_com());
			ps.executeUpdate();
			ps.close();
                        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        return false;
		}
	}

	@Override
	public boolean modifier_com_four(Commande_four cf) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("update LIVRAISON set ID_FOURNISSEUR=?,ID_PRO=?,DATE_COM=?,QUANTITE=? where ID_COM=?");
			ps.setInt(1, cf.getId_four());
			ps.setInt(2, cf.getId_pro());
			ps.setDate(3, cf.getDate());
			ps.setInt(4, cf.getQte_com());
			ps.setInt(5, cf.getId_com());
			ps.executeUpdate();
			ps.close();
                        return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Commande_four> affiche_com_four() {
		// TODO Auto-generated method stub
		List<Commande_four> lp=new ArrayList<>();
		Commande_four cf=null;
		try {
			PreparedStatement ps;
			 ps=co.prepareStatement("select * from LIVRAISON as cf,FOURNISSEUR as f, PRODUIT as p where cf.id_fournisseur=f.id_fournisseur and cf.id_pro=p.id_pro");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cf=new Commande_four();
				cf.setId_com(rs.getInt("id_com"));
				cf.setId_four(rs.getInt("id_fournisseur"));
				cf.setDate(rs.getDate("date_com"));
				cf.setNom_produit(rs.getString("nom_pro"));
				cf.setQte_com(rs.getInt("quantite"));
				cf.setNom_four(rs.getString("nom_fournisseur"));
				cf.setAdresse(rs.getString("add_fournisseur"));
				cf.setTel_four(rs.getString("tel_fournisseur"));
				cf.setVille(rs.getString("ville"));
                                cf.setEntreprises(rs.getString("entreprise"));
				
				lp.add(cf);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp==null)throw new RuntimeException("pas de commandes fournisseurs trouv�e");
		return lp;
	}

	@Override
	public boolean ajouter_dep(Depense p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("insert into depense value(?,?,?,?,?)");
			ps.setInt(1, p.getNumero_dep());
			ps.setString(2, p.getType_dep());
			ps.setString(3, p.getNature());
			ps.setFloat(4, p.getMontant());
			ps.setString(5, p.getDate_dep());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        return false;
		}
                return true;
	}

	@Override
	public void supprimer_dep(Depense p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("delete from depense where NUM_DEPENSE=?" );
			ps.setInt(1, p.getNumero_dep());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifier_dep(Depense p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("update depense set TYPE_DEPENSE=?,NATURE=?,MONTANT=?,DATE_DEP=? where NUM_DEPENSE=?");
			ps.setString(1, p.getType_dep());
			ps.setString(2, p.getNature());
			ps.setFloat(3, p.getMontant());
			ps.setString(4, p.getDate_dep());
			ps.setInt(5, p.getNumero_dep());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Depense> affiche_dep() {
		// TODO Auto-generated method stub
		List<Depense> lp=new ArrayList<>();
		Depense p=null;
		try {
			PreparedStatement ps;
			 ps=co.prepareStatement("select * from depense");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p=new Depense();
				p.setNumero_dep(rs.getInt("NUM_DEPENSE"));
				p.setType_dep(rs.getString("TYPE_DEPENSE"));
				p.setNature(rs.getString("NATURE"));
				p.setMontant(rs.getFloat("MONTANT"));
				p.setDate_dep(rs.getString("DATE_DEP"));
				lp.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp==null)throw new RuntimeException("pas de DEPENSEt trouver");
		return lp;
	}
/*
	@Override
	public void update_quantite(int id_pro, int qte, String action) {
		// TODO Auto-generated method stub
		try {
			Commande_cli c=new Commande_cli();
			int anc_qte=-1;
			PreparedStatement ps;
			if(action=="remove"){
				PreparedStatement p=co.prepareStatement("select quantite from produit where id_pro=?");
				p.setInt(1, id_pro);
				ResultSet rs=p.executeQuery();
				if(rs.next()){
					 anc_qte=rs.getInt("quantite");
				}
				if(qte<=anc_qte){
			 ps=co.prepareStatement("update produit set quantite=quantite-? where id_pro=?");
			ps.setInt(1, qte);
			ps.setInt(2, id_pro);
				}
				else{
					throw new RuntimeException("impossible de retirer la quantite");
				}
			}
			else{
				 ps=co.prepareStatement("update produit set quantite=quantite+? where id_pro=?");
			}
			ps.setInt(1, qte);
			ps.setInt(2, id_pro);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	@Override
	public void update_quantite(int id_pro, int qte, String action) {
		// TODO Auto-generated method stub
		try {
			Commande_cli c=new Commande_cli();
			int anc_qte=-1;
			PreparedStatement ps;
			if(action=="remove"){
				PreparedStatement p=co.prepareStatement("select quantite from PRODUIT where id_pro=?");
				p.setInt(1, id_pro);
				ResultSet rs=p.executeQuery();
				if(rs.next()){
					 anc_qte=rs.getInt("quantite");
				}
				if(qte<=anc_qte){
			 ps=co.prepareStatement("update PRODUIT set quantite=quantite-? where id_pro=?");
			ps.setInt(1, qte);
			ps.setInt(2, id_pro);
				}
				else{
					throw new RuntimeException("impossible de retirer la quantite");
				}
			}
			else{
				 ps=co.prepareStatement("update PRODUIT set quantite=quantite+? where id_pro=?");
			}
			ps.setInt(1, qte);
			ps.setInt(2, id_pro);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int quantite_stock(String niveau) {
		// TODO Auto-generated method stub
		int result=-1;
		PreparedStatement ps;
		try {
			if(niveau=="null"){
			ps=co.prepareStatement("select count(id_pro) from PRODUIT where quantite=0");
			}
			else if(niveau=="bas"){
				ps=co.prepareStatement("select count(id_pro) from PRODUIT where quantite<=10 and QUANTITE!=0");
			}
			else{
				ps=co.prepareStatement("select count(id_pro) from PRODUIT where quantite>10");
			}
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt("count(id_pro)");
				//result=rs.getRow();
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	//version precedente avec la classe commande_cli
	/*@Override
	
	public boolean produit_existe(int id,String nom) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("select* from produit where ID_PRO=? and NOM_PRO=?");
			ps.setInt(1, id);
			ps.setString(2, nom);
			ResultSet rs=ps.executeQuery();
			
			if(!rs.next()){
				
				return false;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

@Override
	
	public boolean produit_existe(String nom) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("select* from PRODUIT where NOM_PRO=?");
			ps.setString(1, nom);
			ResultSet rs=ps.executeQuery();
			
			if(!rs.next()){
				
				return false;
			}
                        
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	
	@Override
	public Commande_cli recherche_com_client_code(int id_com) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande_cli> recherche_com_client(int id_fac) {
		// TODO Auto-generated method stub
		List<Commande_cli> lc=new ArrayList<Commande_cli>();
		Commande_cli cl=null;
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("select * FROM COMMANDE_CLI  c,PRODUIT  p where c.id_pro=p.id_pro and id_fac=? order by c.id_com ASC");
			ps.setInt(1,id_fac);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cl=new Commande_cli(rs.getInt("id_fac"), rs.getInt("id_pro"),rs.getString("p.nom_pro"),rs.getInt("c.quantite"),rs.getInt("c.pri_uni"));
				cl.setId_command(rs.getInt("c.id_com"));
				lc.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lc.isEmpty()) throw new RuntimeException("pas de commande trouver");
		return lc;
	}

	@Override
	public List<Commande_cli> affiche_com_cli() {
		// TODO Auto-generated method stub
		List<Commande_cli> lc=new ArrayList<Commande_cli>();
		Commande_cli cl=null;
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("select * from COMMANDE_CLI  c,PRODUIT  p where c.id_pro=p.id_pro order by c.id_com ASC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cl=new Commande_cli(rs.getInt("id_fac"), rs.getInt("id_pro"),rs.getString("p.nom_pro"),rs.getInt("c.quantite"),rs.getInt("c.pri_uni"));
				cl.setId_command(rs.getInt("c.id_com"));
				lc.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lc.isEmpty()) throw new RuntimeException("pas de commande trouver");
		return lc;
	}

	@Override
	public void supprimer_com_client(Commande_cli cl) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("delete from COMMANDE_CLI where id_com=?");
			ps.setInt(1, cl.getId_command());
			ps.executeUpdate();
			this.update_quantite(cl.getId_pro(), cl.getQte_produit(), "add");
			ps.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Commande_cli> recherche_com_client_date(String Date) {
		// TODO Auto-generated method stub
		List<Commande_cli> lc=new ArrayList<Commande_cli>();
		Commande_cli cl=null;
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("select * from COMMANDE_CLI  c,PRODUIT  p where c.id_pro=p.id_pro and c.date_com=? order by c.id_com ASC");
			ps.setString(1, Date);
                        ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cl=new Commande_cli(rs.getInt("id_fac"), rs.getInt("id_pro"),rs.getString("p.nom_pro"),rs.getInt("c.quantite"),rs.getInt("c.pri_uni"));
				cl.setId_command(rs.getInt("c.id_com"));
				lc.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lc.isEmpty()) throw new RuntimeException("pas de commande trouver");
		return lc;
	}

	/* il s'agit de la version avec la table commande_client_g
	   il suffit juste de decommenter
	 @Override
	public void ajouter_commande(Commande_cli cl) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("insert into commande_cli value(NULL,?,?,?,?,?,?)");
			ps.setInt(1, cl.getId_client());
			ps.setInt(2, cl.getId_pro());
			ps.setInt(3, cl.getId_fac());
			ps.setString(4, cl.getDate_commande());
			ps.setFloat(5, cl.getPrix_uni());
			ps.setInt(6, cl.getQte_produit());
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("ajout reussi");
				this.update_quantite(cl.getId_pro(),cl.getQte_produit(),"remove");
			}
			else{
				System.out.println("echec ajout");
			}
			ps.close();
		
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		
	}*/
	
	@Override
	public void ajouter_commande(Commande_cli cl) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			
			/*ps=co.prepareStatement("select id_pro from produit where nom_pro=?");
			ps.setString(1, cl.getNom_produit());
			ResultSet rs=ps.executeQuery();
			rs.next();
			int id=rs.getInt("id_pro");*/
			
			
			ps=co.prepareStatement("insert into COMMANDE_CLI value(NULL,?,?,?,?)");
			
			ps.setInt(1, cl.getId_pro());
			ps.setInt(2, cl.getId_fac());
                        
			
			ps.setFloat(3, cl.getPrix_uni());
			ps.setInt(4, cl.getQte_produit());
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("ajout reussi");
				this.update_quantite(cl.getId_pro(),cl.getQte_produit(),"remove");
			}
			else{
				System.out.println("echec ajout");
			}
			ps.close();
		
		} catch (SQLException e) {
 			e.printStackTrace();
		}
	}

	@Override
	public void ajouter_listcom(List<Commande_cli> lc) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Commande_cli c=new Commande_cli();
		try {
			ps=co.prepareStatement("insert into FACTURE value(NULL)");
			ps.executeUpdate();
			ps.close();
			
			int r=last_facture();
			
			//on met id de la meme facture � toute les commandes
			for(int i=0;i<lc.size();i++){
				lc.get(i).setId_fac(r);
				lc.get(i).setId_pro(this.recuperation_idpro(lc.get(i).getNom_produit()));
				//System.out.println(i);
				this.ajouter_commande(lc.get(i));
				
				//System.out.println(lc.get(i).getId_fac());
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	@Override
	public void modifier_com_client(Commande_cli cl) {
		// TODO Auto-generated method stub
                
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
        
        //autres methodes pout la gestion des commmandes fournisseurs

    @Override
    public List<Commande_four> recherche_com_for(int id_com) {
        //To change body of generated methods, choose Tools | Templates.
        List<Commande_four> lp=new ArrayList<>();
		Commande_four cf=null;
		try {
			PreparedStatement ps;
			 ps=co.prepareStatement("select * from LIVRAISON as cf,FOURNISSEUR as f, PRODUIT as p where cf.id_fournisseur=f.id_fournisseur and cf.id_pro=p.id_pro and cf.id_com=?");
                         ps.setInt(1, id_com);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cf=new Commande_four();
				cf.setId_com(rs.getInt("id_com"));
				cf.setId_four(rs.getInt("id_fournisseur"));
				cf.setDate(rs.getDate("date_com"));
				cf.setNom_produit(rs.getString("nom_pro"));
				cf.setQte_com(rs.getInt("quantite"));
				cf.setNom_four(rs.getString("nom_fournisseur"));
				cf.setAdresse(rs.getString("add_fournisseur"));
				cf.setTel_four(rs.getString("tel_fournisseur"));
				cf.setVille(rs.getString("ville"));
                                cf.setEntreprises(rs.getString("entreprise"));
				
				lp.add(cf);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas de commandes fournisseurs trouvée");
		return lp;
    }

    @Override
    public void ajouter_listcom_four(List<Commande_four> lc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean quantite_suffisante(String nom,int qte) {
        PreparedStatement p;
        int anc_qte=-1;
            try {
                p = co.prepareStatement("select quantite from PRODUIT where nom_pro=?");
                p.setString(1, nom);
                ResultSet rs=p.executeQuery();
			if(rs.next()){
			 anc_qte=rs.getInt("quantite");
                        
                        
                                if(qte<=anc_qte){
                                     System.out.println("com.implementation.pack.Role.quantite_suffisante()");
                                     return true;
				}
                                 else{
                                     return false;         
                                }
                        
                        }
                        else{
                                    return false;
                        }
            } 
            catch (SQLException ex) {
                return false;
            }
            
			
    }

    @Override
    public boolean ajouter_client(Client c) {
        
        try {
			PreparedStatement ps=co.prepareStatement("insert into CLIENT(NOM_CLIENT,ADD_CLIENT,TEL_CLIENT,VILLE) value(?,?,?,?)");
			ps.setString(1, c.getNom_client());
			ps.setString(2, c.getAddresse());
			ps.setString(3, c.getTelephone());
			ps.setString(4,c.getVille());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public boolean modifier_client(Client c) {
       try {
			PreparedStatement ps=co.prepareStatement("update CLIENT set NOM_CLIENT=?,ADD_CLIENT=?,TEL_CLIENT=?,VILLE=? where ID_CLIENT=?");
			ps.setString(1, c.getNom_client());
			ps.setString(2, c.getAddresse());
			ps.setString(3, c.getTelephone());
			ps.setString(4, c.getVille());
                        ps.setInt(5, c.getId_client());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public boolean supprimer_client(Client c) {
        PreparedStatement ps;
		try {
			ps=co.prepareStatement("delete from COMMANDE_CLI where ID_CLIENT=?" );
			ps.setInt(1, c.getId_client());
			ps.executeUpdate();
			ps=co.prepareStatement("delete from CLIENT where ID_CLIENT=?" );
			ps.setInt(1, c.getId_client());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
		return true;
	
    }

    @Override
    public Client rechercher_client(int id_cli) {
      Client c=null;
		try {
			
                                
			PreparedStatement ps=co.prepareStatement("select * from CLIENT where ID_CLIENT=? and ID_client!=0");
			ps.setInt(1, id_cli);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
                                c=new Client();
				c.setId_client(rs.getInt("id_client"));
                                c.setNom_client(rs.getString("nom_client"));
                                c.setAddresse(rs.getString("add_client"));
                                c.setTelephone(rs.getString("tel_client"));
                                c.setVille(rs.getString("ville"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(c==null)throw new RuntimeException("pas dE CLIENT trouver");
		return c;
    }

    @Override
    public List<Client> rechercher_liste_client(String valeur, String action) {
        List<Client> lp=new ArrayList<Client>();
		
		try {
			PreparedStatement ps;
			
			if(action=="ville"){
				 ps=co.prepareStatement("select * from CLIENT where VILLE=? and ID_client!=0");
                                 ps.setString(1, valeur);
                        }
                        else if(action=="nom"){
                            ps=co.prepareStatement("select * from CLIENT where NOM_CLIENT=? and ID_client!=0");
                            ps.setString(1, valeur);
                        }
                        else {
                            //ici il faut passer la chaine 'tous" dans la variables action
                            ps=co.prepareStatement("select * from CLIENT where ID_client!=0 "); 
                            
                        }
                        
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
                            Client c=new Client();
				c.setId_client(rs.getInt("id_client"));
                                c.setNom_client(rs.getString("nom_client"));
                                c.setAddresse(rs.getString("add_client"));
                                c.setTelephone(rs.getString("tel_client"));
                                c.setVille(rs.getString("ville"));
				lp.add(c);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas de CLIENT trouver");
		return lp;
	
    }

    @Override
    public boolean client_existe(int code) {
        try {
                //il faut que le code du client soit differents du code du client par default
			PreparedStatement ps=co.prepareStatement("select* from CLIENT where ID_CLIENT=? and ID_client!=0");
			ps.setInt(1, code);
			ResultSet rs=ps.executeQuery();
			
			if(!rs.next()){
				
				return false;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public int recup_quantite_stock(String nom) {
        PreparedStatement p;
        try {
                p = co.prepareStatement("select quantite from PRODUIT where nom_pro=?");
                p.setString(1, nom);
                ResultSet rs=p.executeQuery();
			if(rs.next()){
                            int anc_qte=rs.getInt("quantite");
                            return anc_qte;
                        }
                        else{
                             return -1;
                        }
            } 
            catch (SQLException ex) {
                return -1;
            }
         
    }

	public int last_facture() throws SQLException{
        
               PreparedStatement ps=co.prepareStatement("select max(id_fac) from FACTURE");
			ResultSet rs=ps.executeQuery();
			rs.next();
			int r=rs.getInt("max(id_fac)");
            return r;
        }

    @Override
    public String[] list_categorie_rayon(String choix) {
            
           List<String> ls=new ArrayList<String>();
            try {
                if(choix=="categorie"){
                    PreparedStatement ps=co.prepareStatement("select * from categorie");
                    ResultSet rs=ps.executeQuery();
                     while(rs.next()){
                             ls.add(rs.getString("NOM_CATEGORIE"));
                         }
                }
                 else{
                        PreparedStatement ps=co.prepareStatement("select * from rayon");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next()){
                             ls.add(rs.getString("NOM_RAYON"));
                         }
                }
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
            }
            //creation du tableau pour le remplissage des valeurs
            String[] tc=new String[ls.size()];
            for(int i=0;i<tc.length;i++){
                tc[i]=ls.get(i);
            }
            return tc;
    }

    @Override
    public boolean ajouter_categorie(String nom) {
        PreparedStatement ps;
            try {
                ps=co.prepareStatement("insert into categorie value(?)");
                ps.setString(1, nom);
                int r=ps.executeUpdate();
                if(r==0){
                    return false;
                }
                
            } catch (SQLException ex) {
                return false;
            }
            return true;
    }

    @Override
    public void ajouter_rayon(String nom) {
        
    }

    @Override
    public boolean ajouter_facture(Facture f) {
         PreparedStatement ps;
            try {
                ps=co.prepareStatement("insert into facture(id_client,date_fac,total) value(?,?,?)");
                ps.setInt(1, f.getId_client());
                ps.setDate(2, f.getDate_fac());
                ps.setFloat(3, f.getTotal());
                int r=ps.executeUpdate();
                if(r==0){
                    return false;
                }
                
            } catch (SQLException ex) {
                return false;
            }
            return true;
        
    }

    @Override
    public boolean supprimer_facture(Facture f) {
        PreparedStatement ps;
		try {
			
			ps=co.prepareStatement("delete from facture where ID_FAC=?" );
			ps.setInt(1,f.getNum_fac());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
		return true;
    }

    
    @Override
    public List<Facture> list_facture() {
        List<Facture> lc=new ArrayList<Facture>();
		Facture f=null;
		PreparedStatement ps;
		try {
			ps=co.prepareStatement("select * FROM facture f,Client c where exists(select * from commande_cli as cm where f.id_client=c.id_client and  f.id_fac=cm.id_fac order by f.id_fac ASC)");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				f=new Facture(rs.getInt("f.id_fac"),rs.getString("c.nom_client"),rs.getDate("f.date_fac"),rs.getFloat("total"));
				lc.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lc;
    }

    @Override
    public List<Facture> list_facture(int num_fac) {
       List<Facture> lc=new ArrayList<Facture>();
		Facture f=null;
		PreparedStatement ps; 
		try {
			ps=co.prepareStatement("select * FROM facture f,Client c where exists(select * from commande_cli as cm where f.id_client=c.id_client and  f.id_fac=cm.id_fac  and f.id_fac=? order by f.id_fac ASC)");
			ps.setInt(1, num_fac);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				f=new Facture(rs.getInt("f.id_fac"),rs.getString("c.nom_client"),rs.getDate("f.date_fac"),rs.getFloat("total"));
				lc.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lc.isEmpty()) throw new RuntimeException("pas de facturet rouver");
		return lc;
    }

    @Override
    public List<Facture> list_facture(String type,String valeur) {
        List<Facture> lc=new ArrayList<Facture>();
		Facture f=null;
		PreparedStatement ps;
		      try {

            if (type.equals("nom_client")) {
                ps = co.prepareStatement("select * FROM facture f,Client c where exists(select * from commande_cli as cm where f.id_client=c.id_client and  f.id_fac=cm.id_fac  and c.nom_client=? order by f.id_fac ASC)");
            } else {
                ps = co.prepareStatement("select * FROM facture f,Client c where exists(select * from commande_cli as cm where f.id_client=c.id_client and  f.id_fac=cm.id_fac  and f.date_fac=? order by f.id_fac ASC)");
            }
            ps.setString(1, valeur);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = new Facture(rs.getInt("f.id_fac"), rs.getString("c.nom_client"), rs.getDate("f.date_fac"), rs.getFloat("total"));
                lc.add(f);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		if(lc.isEmpty()) throw new RuntimeException("pas de facturetrouver");
		return lc;
    }

    @Override
    public void ajouter_listcom(List<Commande_cli> lc, Facture f) {
            PreparedStatement ps;
		Commande_cli c=new Commande_cli();
		try {
			this.ajouter_facture(f);
			//on recupere le max des numeros de facture
			int r=last_facture();
			
			//on met id de la meme facture � toute les commandes
			for(int i=0;i<lc.size();i++){
				lc.get(i).setId_fac(r);
				lc.get(i).setId_pro(this.recuperation_idpro(lc.get(i).getNom_produit()));
				//System.out.println(i);
				this.ajouter_commande(lc.get(i));
				
				//System.out.println(lc.get(i).getId_fac());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	

}
