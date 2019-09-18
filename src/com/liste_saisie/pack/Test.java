package com.liste_saisie.pack;

import java.awt.Color;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.classes.pack.SingletonConnecction;
import com.implementation.pack.Role;

/**
 * @author David
 */
public class Test {

    public Test() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField f = new JTextField(10);
        
        AutoSuggestor autoSuggestor = new AutoSuggestor(f, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {
            	Role r=new Role();
                //create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
                ArrayList<String> words = new ArrayList<>();
               SingletonConnecction sg=new SingletonConnecction();
               Connection co;
               words=recherche();
                /* words.add("hello");
                words.add("heritage");
                words.add("happiness");
                words.add("goodbye");
                words.add("cruel");
                words.add("car");
                words.add("war");
                words.add("will");
                words.add("world");
                words.add("wall");
									*/

                setDictionary(words);
                //addToDictionary("bye");//adds a single word

                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };

        JPanel p = new JPanel();

        p.add(f);

        frame.add(p);

        frame.pack();
        frame.setVisible(true);
    }
    public ArrayList<String> recherche() {
		// TODO Auto-generated method stub
		//List<Produit> lp=new ArrayList<>();
		ArrayList<String> tab=new ArrayList<>();
		SingletonConnecction sg=new SingletonConnecction();
		Connection co=sg.getConnexion();
		int i=0;
		try {
			PreparedStatement ps;
			
				 ps=co.prepareStatement("select * from produit");
				 //ps.setString(1, val+"%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
				
				tab.add(rs.getString("nom_pro"));
				i++;
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//if(tab.size()==0)throw new RuntimeException("pas de produit trouver");
		return tab;
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}