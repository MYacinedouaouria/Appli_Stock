package com.modele_table.pack;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


import com.classes.pack.Utilisateur;



public class ModelTable_user extends AbstractTableModel{
		
		public List<Utilisateur> l_e=new ArrayList<Utilisateur>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUMERO","LOGIN","TYPE", "NOM"};
		public ModelTable_user(){
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
				return l_e.get(i).getLogin();
			
			case 2:
				return l_e.get(i).getType();
			case 3:
				return l_e.get(i).getNom();
			
			
			default:
				return null;
			}
			
		
		}
		
}
