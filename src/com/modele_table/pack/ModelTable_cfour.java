package com.modele_table.pack;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.classes.pack.Commande_cli;
import com.classes.pack.Commande_four;
import com.classes.pack.Produit;


public class ModelTable_cfour extends AbstractTableModel{
		
		public List<Commande_four> l_e=new ArrayList<Commande_four>();
		//public String[] entete={"MATRICULE","NOM","PRENOM","NOM_FILIERE","NIVEAU","AGE","SEXE"};
		public String [] title={"NUMERO","NOM FOURNISSEUR", "NOM PRODUIT", "PRIX_ACHAT","QUANTITE ACHAT", "DATE"};
		public ModelTable_cfour(){
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
                                return l_e.get(i).getNom_produit();
			
                        case 4:
				return l_e.get(i).getQte_com();
                        case 3:
				return l_e.get(i).getPrix_achat();
                        case 5:
				return l_e.get(i).getDate().toString();
                        
			default:
				return null;
			}
			
		
		}
		
}
