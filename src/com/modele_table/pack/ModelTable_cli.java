package com.modele_table.pack;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import com.classes.pack.Commande_cli;
import com.classes.pack.Produit;


public class ModelTable_cli extends AbstractTableModel{
		
		public List<Commande_cli> l_e=new ArrayList<Commande_cli>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUMERO", "NOM PRODUIT", "PRIX VENTE", "QUANTITE VENDUE", "TOTAL VENTE"};
		public ModelTable_cli(){
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
				return i+1;
			
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
