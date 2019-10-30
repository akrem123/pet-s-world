/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Animal;
import entite.Consultation;
import entite.Glabal;
import entite.Membre;
import entite.User;
import iservices.IMembreService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataSource;

/**
 *
 * @author benra
 */
public class MembreService implements IMembreService{
    
    Connection con;
    Statement ste; //req statique
    PreparedStatement pste; // req dynamique
    ResultSet rs;
    
    public MembreService() {
        con = DataSource.getInstance().getConnection();
        try {
        ste = con.createStatement();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    public void creerMembre(Membre m) {
        
        String img="http://localhost/images/uploads/3.png";
        String req = "INSERT INTO `esprit`.`users` "
                + "(`nom`, `prenom`, `email`, `mdp`, `cin`, `type`, `image`)"
                + " VALUES ('"+m.getNom()+
                "', '"+m.getPrenom()+"', '"+m.getEmail()+"', '"+m.getMdp()+"', '"+m.getCin()+"', '"+m.getType()+"', '"+img+"');";
        
      
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void creerAnimal(Animal a, int id) {
        
        
        String req = "INSERT INTO `esprit`.`animal` "
                + "(`nom`, `espece`, `race`, `birthdate`, `gender`, `taille`, `poids`, `userid`)"
                + " VALUES ('"+a.getNom()+
                "', '"+a.getEspece()+"', '"+a.getRace()+"', '"+a.getBirthdate()+"', '"+a.getGender()+"', '"+a.getTaille()+"', '"+a.getPoids()+"', '"+id+"');";
        
      
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    public void creerConsultation(Consultation c, int id) {
        
        String eta = "Untreated";
        String req = "INSERT INTO `esprit`.`consultation` "
                + "(`sujet`, `type`, `description`, `date`, `debut`, `fin`, `etat`, `animalid`)"
                + " VALUES ('"+c.getSujet()+
                "', '"+c.getType()+"', '"+c.getDescription()+"', '"+c.getDate()+"', '"+c.getDebut()+"', '"+c.getFin()+"', '"+eta+"', '"+id+"');";
        
      
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public Membre updateprofile(int id) {
        
        String req = "select * from `users` where id="+id;
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
     Membre m =new Membre(res.getString("prenom"),res.getString("nom"),res.getInt("cin"),res.getString("mdp"));
            return m;
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
       return null;
}
    
    public void deleteMembre(int id) {
     String req = "delete from `users` "
             + "where id="+id;
     
        try {
            pste = con.prepareStatement(req);
         //   pste.setInt(1, m.getId());
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteAnimal(int id) {
     String req = "delete from `animal` "
             + "where id="+id;
     
        try {
            pste = con.prepareStatement(req);
         
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public String test1(int id) {
        
        String req = "select * from `users` where id="+id;
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
     //Membre m =new Membre(res.getInt("type"),res.getInt("id"),res.getString("email"),res.getString("mdp"));
      String nom=res.getString("nom");
            return nom;  
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
       return "gg";
}
    
    public String test2(int id) {
        
        String req = "select * from `users` where id="+id;
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
     //Membre m =new Membre(res.getInt("type"),res.getInt("id"),res.getString("email"),res.getString("mdp"));
      String prenom=res.getString("prenom");
            return prenom;  
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
       return "gg";
}
    
    public Animal consultationgetid(int id) {
        
        String req = "select * from `animal` where id="+id;
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
            Animal a = new Animal(res.getInt("id"),res.getString("nom"), res.getString("espece"), res.getString("race"), res.getString("birthdate"), res.getString("gender"), res.getInt("taille"), res.getInt("poids"));
            return a;  
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
       return null;
}
    
    
    public void updateMembre(String p,String n, int c, String m , int id) {
        String req = "update `esprit`.`users` set prenom=?,nom=? ,cin=?,mdp=?  where id=?";
        try {
        PreparedStatement preparedStmt = con.prepareStatement(req);
      preparedStmt.setString  (1, p);
      preparedStmt.setString  (2, n);
       preparedStmt.setInt  (3, c);
      preparedStmt.setString  (4, m);
       preparedStmt.setInt  (5, id);
      preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateAnimal(String n, String e, String r, String b, String g, int t, int p, int id) {
        String req = "update `esprit`.`animal` set nom=? ,espece=? ,race=? ,birthdate=? ,gender=? ,taille=? ,poids=?  where id=?";
        try {
        PreparedStatement preparedStmt = con.prepareStatement(req);
      preparedStmt.setString  (1, n);
      preparedStmt.setString  (2, e);
      preparedStmt.setString  (3, r);
      preparedStmt.setString  (4, b);
      preparedStmt.setString  (5, g);
       preparedStmt.setInt  (6, t);
       preparedStmt.setInt  (7, p);
       preparedStmt.setInt  (8, id);
      preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateCons(String p, int id) {
        String req = "update `esprit`.`consultation` set etat=?  where id=?";
        try {
        PreparedStatement preparedStmt = con.prepareStatement(req);
      preparedStmt.setString  (1, p);
      preparedStmt.setInt  (2, id);
      preparedStmt.executeUpdate();
      
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Membre> SearchName(String comment) throws SQLException{
        String requete="SELECT * FROM users where prenom LIKE'%"+comment+"%'" ;
        ste = con.createStatement() ;
        rs=ste.executeQuery(requete);
        List<Membre> list = new ArrayList<>() ; 
        while(rs.next()){
        
        Membre p = new Membre(
                      rs.getInt("id")
                    , rs.getString("nom")
                    , rs.getString("prenom")
                    , rs.getString("email")
                    , rs.getString("mdp")
                    , rs.getInt("cin")
                    , rs.getString("phone")
                    , rs.getString("adress")
                    , rs.getString("city"));
            
        
        list.add(p) ;
        }
        
        
        
        return list ;
    }
    
    public List<Membre> SearchPhone(String comment) throws SQLException{
        String requete="SELECT * FROM users where phone LIKE'%"+comment+"%'" ;
        ste = con.createStatement() ;
        rs=ste.executeQuery(requete);
        List<Membre> list = new ArrayList<>() ; 
        while(rs.next()){
        
        Membre p = new Membre(
                      rs.getInt("id")
                    , rs.getString("nom")
                    , rs.getString("prenom")
                    , rs.getString("email")
                    , rs.getString("mdp")
                    , rs.getInt("cin")
                    , rs.getString("phone")
                    , rs.getString("adress")
                    , rs.getString("city"));
            
        
        list.add(p) ;
        }
        return list ;
    }
    
    
    public ArrayList<Membre> getAllUsers() throws SQLException {

        ArrayList<Membre> membres = new ArrayList<>();
        String req = "select * from users";
        Statement ste = con.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {
            Membre p = new Membre(
                      rst.getInt("id")
                    , rst.getString("nom")
                    , rst.getString("prenom")
                    , rst.getString("email")
                    , rst.getString("mdp")
                    , rst.getInt("cin")
                    , rst.getString("phone")
                    , rst.getString("adress")
                    , rst.getString("city"));
            membres.add(p);
        }
        return membres;
    }
    
    
    public ArrayList<Consultation> getAllCons(int id) throws SQLException {

        ArrayList<Consultation> consultations = new ArrayList<>();
        String req = "select * from consultation where animalid="+id;
        Statement ste = con.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {
            Consultation p = new Consultation(
                      rst.getInt("id")
                    , rst.getString("sujet")
                    , rst.getString("type")
                    , rst.getString("description")
                    , rst.getString("date")
                    , rst.getString("debut")
                    , rst.getString("fin")
                    , rst.getString("etat"));
            consultations.add(p);
        }
        return consultations;
    }
    
    
    
    public boolean emailexist(String email) {
        
        String req = "select * from users";
        ArrayList<String> emailsmembres = new ArrayList<>();
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
      String m =res.getString("email");
      emailsmembres.add(m);
              
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if(emailsmembres.contains(email)){
            return false;
        }
        return true;
        
        
        
    
}
    
    
    
    
    public boolean logintest(String mail,String dp) {
        
        String req = "select * from users";
        ArrayList<Membre> loginmembres = new ArrayList<>();
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
      Membre m =new Membre(res.getInt("id"),res.getString("email"),res.getString("mdp"),res.getString("type"));
      loginmembres.add(m);
              
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       for(int i = 0 ; i < loginmembres.size(); i++){
     
          if(loginmembres.get(i).getEmail().equals(mail)&&loginmembres.get(i).getMdp().equals(dp)){
              
              Glabal.id=loginmembres.get(i).getId();
              Glabal.type=loginmembres.get(i).getType();
             
             
             return true;
          }
        }
        return false;
       
}
    
    public void updatePassword(String e,String p) {
        String req = "update `esprit`.`users` set mdp=? where email=?";
        try {
        PreparedStatement preparedStmt = con.prepareStatement(req);
      preparedStmt.setString  (1, p);
      preparedStmt.setString  (2, e);
      preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    public String photourl(int id) {
        
        String req = "select * from `users` where id="+id;
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            while (res.next()) {
     //Membre m =new Membre(res.getInt("type"),res.getInt("id"),res.getString("email"),res.getString("mdp"));
      String url=res.getString("image");
            return url;  
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
       return "gg";
}
    
    
    public void Photo(String p, int id) {
        String req = "update `esprit`.`users` set image=?  where id=?";
        try {
        PreparedStatement preparedStmt = con.prepareStatement(req);
      preparedStmt.setString  (1, p);
      preparedStmt.setInt  (2, id);
  
      preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList CreatMyList(int id){
    
            Statement ste ;
            ResultSet rs;
            Membre membre; 
            ArrayList ListMembres= new <Membre> ArrayList();
            
            try{
            
            ste = con.createStatement();
            
            //String requete=requette+(Row_Number-1);
            rs = ste.executeQuery("select * from `users` where id="+id);
            
            while(rs.next()){
                membre= new Membre();
                membre.setId(rs.getInt("id"));
                membre.setPrenom(rs.getString("prenom"));
                membre.setNom(rs.getString("nom"));
                membre.setEmail(rs.getString("email"));
                membre.setPhone(rs.getString("phone"));
                membre.setAdress(rs.getString("adress"));
                membre.setCity(rs.getString("city"));
                

                ListMembres.add(membre);
            }
                
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
            
            return ListMembres; 
    
    }
    
    
    public ArrayList CreatMyList2(int id){
    
            Statement ste ;
            ResultSet rs;
            Animal animal; 
            ArrayList ListAnimals= new <Animal> ArrayList();
            
            try{
            
            ste = con.createStatement();
            
            //String requete=requette+(Row_Number-1);
            rs = ste.executeQuery("select * from `animal` where userid="+id);
            
            while(rs.next()){
                animal= new Animal();
                animal.setId(rs.getInt("id"));
                animal.setNom(rs.getString("nom"));
                animal.setEspece(rs.getString("espece"));
                animal.setRace(rs.getString("race"));
                animal.setBirthdate(rs.getString("birthdate"));
                animal.setGender(rs.getString("gender"));
                animal.setTaille(rs.getInt("taille"));
                animal.setPoids(rs.getInt("poids"));

                ListAnimals.add(animal);
            }
                
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
            
            return ListAnimals; 
    
    }
    
    public ArrayList CreatMyList3  (int id){
    
            Statement ste ;
            ResultSet rs;
            Animal animal; 
            ArrayList ListAnimals= new <Animal> ArrayList();
            
            try{
            
            ste = con.createStatement();
            
            //String requete=requette+(Row_Number-1);
            rs = ste.executeQuery("select * from `animal` where userid="+id);
            
            while(rs.next()){
                animal= new Animal();
                animal.setId(rs.getInt("id"));
                animal.setNom(rs.getString("nom"));
                animal.setEspece(rs.getString("espece"));
                animal.setRace(rs.getString("race"));
                animal.setBirthdate(rs.getString("birthdate"));
                animal.setGender(rs.getString("gender"));
                animal.setTaille(rs.getInt("taille"));
                animal.setPoids(rs.getInt("poids"));

                ListAnimals.add(animal);
            }
                
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
            
            return ListAnimals; 
    
    }
    
    
    
    
    }
    

