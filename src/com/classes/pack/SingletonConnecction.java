package com.classes.pack;
//package com.metier.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class SingletonConnecction {
	public static Connection connexion;
	
		static{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit2","root","");
				//System.out.println("Connexion effective !");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "impossible de lancer appli-stock car aucune connection avec  la base de donnée");
			}
                        
			
		}

		public static Connection getConnexion() {
			return connexion;
		}
		
	
}
