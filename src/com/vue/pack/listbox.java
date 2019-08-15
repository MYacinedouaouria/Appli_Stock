package com.vue.pack;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.classes.pack.Produit;
import com.classes.pack.SingletonConnecction;
import com.implementation.pack.Role;

public class listbox extends JFrame{
	JScrollPane jsp;
	Label l_nom=new Label("NOM");
	JFrame pp=new JFrame();
	JTextField nom=new JTextField("tom");
	JPanel jp=new JPanel();
	JPanel jp1=new JPanel();
	String[] tab={"frank","junior","calvin","frank","junior","calvin","frank","junior","calvin"};
	//java.util.List<Produit> lp=new ArrayList<>();
	Role role=new Role();
	JList list;
	
	public listbox(){
		pp=this;
		nom.setPreferredSize(new Dimension(80, 25));
		this.setVisible(true);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		list=new JList<>();
		list.setVisible(false);
		list.setOpaque(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		jp1.add(l_nom);
		jp1.add(nom);
		 jsp=new JScrollPane(list);
		jsp.setPreferredSize(new Dimension(200, 90));
		jp.add(jp1);
		jp.add(jsp);
		nom.getDocument().addDocumentListener(new saisie());
		list.addListSelectionListener(new selection());
		this.setContentPane(jp);
		jsp.setVisible(true);
		
	}
	public class selection implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
				
				String val=(String)list.getSelectedValue();
					nom.setText(val);
					jsp.setVisible(false);
					
			
		}
		
	}
	public String[] recherche(String val) {
		// TODO Auto-generated method stub
		//List<Produit> lp=new ArrayList<>();
		String[] tab = new String[10];
		SingletonConnecction sg=new SingletonConnecction();
		Connection co=sg.getConnexion();
		int i=0;
		try {
			PreparedStatement ps;
			
				 ps=co.prepareStatement("select * from produit where nom_pro like ?");
				 ps.setString(1, val+"%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
				
				tab[i]=rs.getString("nom_pro");
				i++;
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(tab.length==0)throw new RuntimeException("pas de produit trouver");
		return tab;
	}
	public class saisie implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			String[] tnom=new String[10];
			String val=nom.getText();
			tnom=recherche(val);
			list.setListData(tnom);
			
			list.setVisible(true);
			jsp.setVisible(true);
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
}
