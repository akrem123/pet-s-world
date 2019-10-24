/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAIFOUN
 */
public class Datasource {
    
     private  String url="jdbc:mysql://localhost:3306/evenement";
        private  String username="root";
        private  String password="";
        private  Connection connection;
        private static Datasource instance;
        
        
        
        
    
 private Datasource(){  
            try {
                connection =DriverManager.getConnection(url, username, password);
                System.out.println("connection etablie");
            } catch (SQLException ex) {
                Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
            }
}    

    public Connection getConnection() {
        return connection;
    }
 
 
 
 
 public static Datasource getInstance(){
     if(instance == null)
         instance =new Datasource();
     return instance;
 }
    
}
