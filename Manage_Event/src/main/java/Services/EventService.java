/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.Datasource;

/**
 *
 * @author SAIFOUN
 */
public class EventService {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Event ev;
    
    public EventService() {
        cnx=Datasource.getInstance().getConnection();
    }
    
     public void insertEventVet(Event e){
        String req="insert into events (NomEvent,CategorieEvent,NbrPlaceDispo,DateEvent,HeureDebEvent,Etat,organisateur,image_ev) values ('"+e.getNomEvent()+"','"+e.getCategorieEvent()+"','"+e.getNbrPlaceDispo()+"','"+e.getDateEvent()+"','"+e.getHeureDebEvent()+"','"+"En attente"+"','"+"Veterinaire"+"','"+e.getImage_ev()+"')";
       
        try {
            ste= cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
     
      public void insertEventCoiff(Event e){
        String req="insert into events (NomEvent,CategorieEvent,NbrPlaceDispo,DateEvent,HeureDebEvent,Etat,organisateur,image_ev) values ('"+e.getNomEvent()+"','"+e.getCategorieEvent()+"','"+e.getNbrPlaceDispo()+"','"+e.getDateEvent()+"','"+e.getHeureDebEvent()+"','"+"En attente"+"','"+"Coiffeur"+"','"+e.getImage_ev()+"')";
       
        try {
            ste= cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
/////////////////////////////////////////////////////////////////////////////////////////     
     public List<Event> readAll(){
        String req="select * from events";
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Event(rs.getInt("IdEvent"),rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getInt("NbrPlaceDispo"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent"),rs.getString("Etat"),rs.getString("organisateur"),rs.getString("image_ev")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }
     
      public List<Event> readById(int id){
        String req="select * from events where IdEvent="+id;
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Event(rs.getInt("IdEvent"),rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getInt("NbrPlaceDispo"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent"),rs.getString("Etat"),rs.getString("organisateur")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
       }
      
       public void deleteEvent(int id){
        String req="delete from events where IdEvent="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void updateEvent(int id){
        String req="update events set Etat='"+"ACCEPTER"+"' where IdEvent="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void supprimer(int id) {
        String req= "delete from `events`  where IdEvent="+id;
        
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
             Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public List<Event> readAll2(){
        String req="select NomEvent,CategorieEvent,DateEvent,HeureDebEvent from events";
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Event(rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }
      
     public List<Event> filterC1(){
       String requete="SELECT NomEvent,CategorieEvent,DateEvent,HeureDebEvent FROM events Where CategorieEvent = 'Tournoi' AND Etat='ACCEPTER' ORDER BY DateEvent DESC" ;
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                list.add(new Event(rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       }
      
  
     // String requete="SELECT NomEvent,CategorieEvent,DateEvent,HeureDebEvent FROM events Where CategorieEvent = 'EVENT1' AND Etat='ACCEPTER' ORDER BY DateEvent DESC" ;
     
      //"Tournoi", "Fete","Journée","Festival");
     public List<Event> filterC2(){
       String requete="SELECT NomEvent,CategorieEvent,DateEvent,HeureDebEvent FROM events Where CategorieEvent = 'Fete' AND Etat='ACCEPTER' ORDER BY DateEvent DESC" ;
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                list.add(new Event(rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       } 
     
     
     ///////////////////////////////////
      public List<Event> filterC3(){
       String requete="SELECT NomEvent,CategorieEvent,DateEvent,HeureDebEvent FROM events Where CategorieEvent = 'Journée' AND Etat='ACCEPTER' ORDER BY DateEvent DESC" ;
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                list.add(new Event(rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       } 
      //Festival
       public List<Event> filterC4(){
       String requete="SELECT NomEvent,CategorieEvent,DateEvent,HeureDebEvent FROM events Where CategorieEvent = 'Festival' AND Etat='ACCEPTER' ORDER BY DateEvent DESC" ;
        List<Event> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                list.add(new Event(rs.getString("NomEvent"),rs.getString("CategorieEvent"),rs.getString("DateEvent"),rs.getInt("HeureDebEvent")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return list;
       } 
      
      
}

