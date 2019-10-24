  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.Datasource;

/**
 *
 * @author SAIFOUN
 */
public class EventService {
     private Connection cnx; // st 
    private Connection con;
    private Statement ste;
    private Statement st;
    private ResultSet rs;
    PreparedStatement pste;
    
    public EventService(){
    cnx = Datasource.getInstance().getConnection();
    }
    
    public void insert(Event e)
    {
         String req="insert into events(organisateur,nom_event,categorie_event,date,Lieu,image) values ('"+e.getOrganisateur()+"','"+e.getNom_event()+"','"+e.getCategorie_event()+"','"+e.getDate_event()+"','"+e.getLieu()+"','"+e.getImage()+"')";
        // String req="insert into etud(nom,prenom) values ('"+p.getNom()+"','"+p.getPrenom()+" ')";
        // ('"+e.getOrganisateur()+"','"+e.getNom_event()+"')";
        try {
          
            ste=cnx.createStatement();
            
          // ste.executeUpdate(req);
           ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    /*
    
    */
    
    public List<Event> readAll(){
        String req="select organisateur,nom_event,categorie_event from events";
        List<Event> list=new ArrayList<>();
        try {
            st=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
             list.add(new Event(rs.getString("organisateur"),rs.getString("nom_event"),rs.getString("categorie_event"),rs.getString("date"),rs.getString("Lieu"),rs.getString("image")));
             //list.add(new Event(rs.getString("organisateur"),rs.getString("nom_event"),rs.getString("categorie_event"),rs.getString("date"),rs.geti("hour")rs.getString("Lieu"),rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
        
    }
    public void supprimer(int id)
    {
       
          String query = "delete from `events` "
             + "where 	id= ?";
           
         try {
      pste = cnx.prepareStatement(query);
            pste.setInt(1, id);
            pste.executeUpdate();
      
     }catch(SQLException ex){
        Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
     public void modifier(int id, String organisateur, String nom_event,String categorie_event) {
        String req="update events set organisateur='"+organisateur+"',nom_event='"+nom_event+"',categorie_event='"+categorie_event+"' where id="+id;
        //  String req="update EVENT set organisateur='"+organisateur+"',nom_event='"+nom_event+"' where id="+id;
         try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*   CHERCHER
    public List<Event> search(int id) {
           String req="select * from events where id="+id;
        List<Event> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                //list.add(new Event(rs.getString("organisateur"),rs.getString("nom_event",rs.getString("categorie_event"));
              list.add(new Event(rs.getString("organisateur"),rs.getString("nom_event"),rs.getString("categorie_event"),r));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list; 
    }
    
    */
}
