/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Demande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataSource;

/**
 *
 * @author Asus
 */
public class AnnonceService {
     private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    PreparedStatement pste;
    
    public AnnonceService() {
        cnx=DataSource.getInstance().getConnection();
    }
    
    public void insert(Demande d) {
        //'"+d.getNumero()+"',
        String req="insert into demande (dateann,nom,prenom,type,description,imagee) values ('"+d.getDateann()+"','"+d.getNom()+"','"+d.getPrenom()+"','"+d.getType()+"','"+d.getDescription()+"','"+d.getImagee()+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public List<Demande> readAll(){
        String req="select * from demande";
        List<Demande> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               
                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Demande(rs.getInt("numero"),rs.getString("dateann"),rs.getString("nom"), rs.getString("prenom"),rs.getString("type"),rs.getString("description"),rs.getString("imagee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
        
    }
     
      public void supprimer(int numero) {
        String req= "delete from `demande` " + "where numero=?";
        
        try {
            pste = cnx.prepareStatement(req);
            pste.setInt(1, numero);
            pste.executeUpdate();
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void modifier(int numero,String dateann,String nom, String prenom,String type, String description) {
        String req="update demande set dateann='"+dateann+"',nom='"+nom+"',prenom='"+prenom+"',type='"+type+"',description='"+description+"' where numero="+numero;
        
         try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          public List<Demande> chercher(int numero){
        String req="select * from demande where id="+numero;
        List<Demande> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               
                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Demande(rs.getInt("numero"),rs.getString("dateann"),rs.getString("nom"), rs.getString("prenom"),rs.getString("type"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
        
    }
     
}
