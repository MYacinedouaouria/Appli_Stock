package com.modele_table.pack;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.classes.pack.Produit;


public class ModelTable extends AbstractTableModel{
		
		public List<Produit> l_e=new ArrayList<Produit>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUMERO", "NOM", "CATEGORIE","PRIX UNITAIRE", "QUANTITE EN STOCK","STOCK ALERT"};
		public ModelTable(){
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
				return l_e.get(i).getId_categorie();
			
			case 3:
				return l_e.get(i).getPrix_unitaire();
			case 4:
				return l_e.get(i).getQuantite();
			case 5:
				return l_e.get(i).getAlert();
			default:
				return null;
			}
			
		
		}
		
}
