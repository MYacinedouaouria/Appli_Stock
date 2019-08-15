/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes.pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class test {
    
    public void inserer(){
    
         SingletonConnecction sg=new SingletonConnecction();
        Connection co=sg.getConnexion();
        java.util.Date cur=new java.util.Date();
        Date d=new Date(cur.getYear(), cur.getMonth(), cur.getDate());
        try {
            PreparedStatement ps=co.prepareStatement("insert into datee value(?,?)");
            ps.setInt(1, 4);
            ps.setDate(2, d);
                    ps.executeUpdate();
                    ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
       };
}
