package com.modele_table.pack;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import com.classes.pack.Commande_cli;
import com.classes.pack.Facture;
import com.classes.pack.Produit;


public class ModelTable_fac extends AbstractTableModel{
		
		public List<Facture> l_e=new ArrayList<Facture>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"STATUT DU VENDEUR", "NOM CLIENT","DATE", "TOTAL"};
		public ModelTable_fac(){
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
				return l_e.get(i).getNom_vendeur()+" ("+l_e.get(i).getStatut_vendeur()+")";
			
			case 1:
				return l_e.get(i).getNom_client();
			
			case 2:
				return l_e.get(i).getDate_fac();
			
			case 3:
				return l_e.get(i).getTotal();
			default:
				return null;
			}
			
		
		}
		
}
