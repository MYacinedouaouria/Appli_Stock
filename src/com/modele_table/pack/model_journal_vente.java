package com.modele_table.pack;

import com.classes.pack.Journal_vente;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.classes.pack.Produit;


public class model_journal_vente extends AbstractTableModel{
		
		public List<Journal_vente> lv= new ArrayList<Journal_vente>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUMERO","NOM PRODUIT","CATEGORIE","QUANTITE", "TOTAL"};
		public model_journal_vente(){
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
			return lv.size();
		}

		@Override
		public Object getValueAt(int i, int j) {
			// TODO Auto-generated method stub
			switch (j) {
			case 0:
				return i+1;
			case 1:
				return lv.get(i).getNom_pro();
			case 2:
				return lv.get(i).getCategorie();
			
			case 3:
				return lv.get(i).getQuantite_vendues();
			case 4:
				return lv.get(i).getTotal_vendu();
			
			default:
				return null;
			}
			
		
		}
		
}
