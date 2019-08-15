/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.implementation.pack;

import com.classes.pack.SingletonConnecction;
import com.classes.pack.Utilisateur;
import com.graphisme.pack.role_acteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Acteur implements role_acteur {

    SingletonConnecction sg=new SingletonConnecction();
    Connection co=sg.getConnexion();
    @Override
    public boolean ajouter_user(Utilisateur u) {
        // TODO Auto-generated method stub
		try {
			PreparedStatement ps=co.prepareStatement("insert into admin value(?,?,?,?)");
			ps.setString(1, u.getLogin());
                        ps.setString(2, u.getPassword());
                        ps.setString(3, u.getType());
                        ps.setString(4, u.getNom());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                        return false;
			
		}
		return true;
    }

    @Override
    public boolean modifier_user(Utilisateur u) {
       try {
			PreparedStatement ps=co.prepareStatement("update admin set password=?,type=?,nom=? where login=?");
			ps.setString(1,u.getPassword());
			ps.setString(2, u.getType());
                        ps.setString(3, u.getNom());
                        ps.setString(4, u.getLogin());
                        
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public boolean supprimer_user(Utilisateur u) {
       PreparedStatement ps;
		try {
			ps=co.prepareStatement("delete from admin where login=?" );
			ps.setString(1, u.getLogin());
                       
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
		return true;
    }

    @Override
    public List<Utilisateur> rechercher(String type,String action) {
        List<Utilisateur> lp=new ArrayList<>();
		Utilisateur p=null;
		try {
			PreparedStatement ps;
			if(action=="nom"){
			  ps=co.prepareStatement("select * from admin where nom=?");
			  ps.setString(1, type);
			}
                        else if(action=="login"){
                             ps=co.prepareStatement("select * from admin where login=?");
			  ps.setString(1, type);
                        }
                        else if(action=="type"){
                            ps=co.prepareStatement("select * from admin where type=?");
			  ps.setString(1, type);
                        }
                        else{
                             ps=co.prepareStatement("select * from admin");
				
                        }
				
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p=new Utilisateur(rs.getString("login"),rs.getString("password"),rs.getString("type"),rs.getString("nom"));
				lp.add(p);
                                
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(lp.isEmpty())throw new RuntimeException("pas d'utilisateur touver");
		return lp;
    }

    @Override
    public  Utilisateur connection(String login, String password) {
        
        PreparedStatement ps;
        try {
            ps=co.prepareStatement("select * from admin where LOGIN=? and PASSWORD=?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Utilisateur user=new Utilisateur(login, password, rs.getString("TYPE"),rs.getString("NOM"));
                return user;
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

  
   
    
}
