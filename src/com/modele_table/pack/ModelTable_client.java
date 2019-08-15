package com.modele_table.pack;

import com.classes.pack.Client;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.classes.pack.Produit;


public class ModelTable_client extends AbstractTableModel{
		
		public List<Client> l_e=new ArrayList<Client>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={ "NUMERO","NOM", "ADRESSE", "TELEPHONE", "VILLE"};
		public ModelTable_client(){
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
				return l_e.get(i).getNom_client();
			case 2:
				return l_e.get(i).getAddresse();
			case 3:
				return l_e.get(i).getTelephone();
			case 4:
				return l_e.get(i).getVille();
			
			default:
				return null;
			}
			
		
		}
		
}
