package com.modele_table.pack;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import com.classes.pack.stat_histogramme;


public class model_stat_hist extends AbstractTableModel{
		
		public List<stat_histogramme> l_e=new ArrayList<stat_histogramme>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"DATE", "MONTANT TOTAL"};
		public model_stat_hist(){
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
				return l_e.get(i).getDate();
			case 1:
				return l_e.get(i).getMontant();
			
			default:
				return null;
			}
			
		
		}
		
}
