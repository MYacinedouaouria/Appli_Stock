package com.modele_table.pack;

import com.classes.pack.Depense;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;




public class ModelTable_dep extends AbstractTableModel{
		
		public List<Depense> l_e=new ArrayList<Depense>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUM DEPENSE", "TYPE", "NATURE", "MONTANT", "DATE"};
		public ModelTable_dep(){
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
				return l_e.get(i).getType_dep();
			case 2:
				return l_e.get(i).getNature();
			case 3:
				return l_e.get(i).getMontant();
			case 4:
				return l_e.get(i).getDate_dep();
			
			default:
				return null;
			}
			
		
		}
		
}
