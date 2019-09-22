package com.modele_table.pack;


import com.classes.pack.bilan_depense;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;




public class ModelTable_bilan_dep extends AbstractTableModel{
		
		public List<bilan_depense> l_e=new ArrayList<bilan_depense>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"DATE", "TYPE", "NATURE", "MONTANT"};
		public ModelTable_bilan_dep(){
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
				return l_e.get(i).getDate_dep();
			case 1:
				return l_e.get(i).getType();
			case 2:
				return l_e.get(i).getNature();
			case 3:
				return l_e.get(i).getMontant();
			
			default:
				return null;
			}
			
		
		}
		
}
