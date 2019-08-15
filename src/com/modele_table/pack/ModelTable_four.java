package com.modele_table.pack;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.classes.pack.Fournisseur;
import com.classes.pack.Produit;


public class ModelTable_four extends AbstractTableModel{
		
		public List<Fournisseur> l_e=new ArrayList<Fournisseur>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUMERO","NOM", "ENTREPRISE","ADDRESSE", "TELEPHONE", "VILLE"};
		public ModelTable_four(){
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
				return l_e.get(i).getNom_four();
			case 2:
				return l_e.get(i).getEntreprise();
			case 3:
				return l_e.get(i).getAddresse();
			case 4:
				return l_e.get(i).getTel_four();
			case 5:
				return l_e.get(i).getVille_four();
			
			default:
				return null;
			}
			
		
		}
		
}
