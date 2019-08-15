package com.modele_table.pack;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.classes.pack.Commande_cli;
import com.classes.pack.Produit;


public class panier_commande extends AbstractTableModel{
		
		public List<Commande_cli> l_e=new ArrayList<Commande_cli>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"CODE CLIENT","NOM PRODUIT", "PTIX ACHAT", "QUANTITE", "TOTAL"};
		public panier_commande(){
			super();
			
			
		}
		@Override
		public String getColumnName(int index) {
			// TODO Auto-generated method stub
			return title[index];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return l_e.size();
		}

		@Override
		public Object getValueAt(int i, int j) {
			// TODO Auto-generated method stub
			switch (j) {
			case 0:
				return l_e.get(i).getId_client();
			case 1:
				return l_e.get(i).getNom_produit();
			case 2:
				return l_e.get(i).getPrix_uni();
			case 3:
				return l_e.get(i).getQte_produit();
			case 4:
				return l_e.get(i).getTotal();
			default:
				return null;
			}
			
		
		}
		
}
