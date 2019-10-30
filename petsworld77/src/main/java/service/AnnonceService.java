/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Adoption;
import entite.Demande;
import entite.Glabal;
import static gui.AfficherAnnonceController.an;
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
import util.DataSource;

/**
 *
 * @author Asus
 */
public class AnnonceService {
    MembreService ms = new MembreService();

    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    PreparedStatement pste;

    public AnnonceService() {
        cnx = DataSource.getInstance().getConnection();
    }

    public void insert(Demande d) {
        //'"+d.getNumero()+"',
        String req = "insert into demande (dateann,nom,prenom,type,description,imagee) values ('" + d.getDateann() + "','" + ms.test2(Glabal.id)+ "','"+ms.test1(Glabal.id)+ "','" + d.getType() + "','" + d.getDescription() + "','" + d.getImagee() + "')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Demande> readAll() {
        String req = "select * from demande ";
        ObservableList<Demande> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {

                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Demande(rs.getInt("numero"), rs.getString("dateann"),rs.getString("nom"),rs.getString("prenom"), rs.getString("type"), rs.getString("description"), rs.getString("imagee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void supprimer(int numero) {
        String req = "delete from `demande` " + "where numero=?";

        try {
            pste = cnx.prepareStatement(req);
            pste.setInt(1, numero);
            pste.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifier(int numero, String dateann, String type, String description, String imagee) {
        String req = "update demande set dateann='" + dateann + "',type='" + type + "',description='" + description + "',image='" + imagee + "' where numero=" + numero;

        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Demande> chercher(String nom) {
        //ms.test1(Glabal.id)
        
        
        String req = "select * from demande where nom  like '" + nom + "'";
        List<Demande> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {

                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Demande(rs.getInt("numero"), rs.getString("dateann"),rs.getString("type"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void insert1(Demande d) {
        //'"+d.getNumero()+"',
        String req = "insert into adoption (dateann,nom,prenom,type,description,imagee) values ('" + d.getDateann() + "','" + d.getNom() + "','" + d.getPrenom() + "','" + d.getType() + "','" + d.getDescription() + "','" + d.getImagee() + "')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Adoption> readAll1() {
        String req = "select * from `adoption` where Nom_adop='"+ms.test2(Glabal.id).toUpperCase()+"'";
        ObservableList<Adoption> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {

                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Adoption(rs.getInt("Id_adoption"), rs.getString("Dateann"), rs.getString("nom"), rs.getString("Prenom"), rs.getString("Type"), rs.getString("Description"), rs.getString("Imagee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }


 public void modifier33(int numero, Demande d) {
        String req = "update demande set dateann='" + d.getDateann() + "',type='" + d.getType() + "',description='" + d.getDescription() + "',imagee='" + d.getImagee() + "' where numero=" + numero;

        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 
 
  public ObservableList<Demande> readAll2() {
        String req ="select * from `demande` where nom='"+ms.test2(Glabal.id).toUpperCase()+"'";
        ObservableList<Demande> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {

                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Demande(rs.getInt("numero"), rs.getString("dateann"),rs.getString("nom"),rs.getString("prenom"), rs.getString("type"), rs.getString("description"), rs.getString("imagee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
  
      public void insertAdop(Adoption a) {
        //'"+d.getNumero()+"',
        String req = "insert into adoption (Dateann,Nom,Prenom,Nom_adop,Prenom_adop,Type,Description,Imagee,Status) values ('" +an.getDateann()+"','" + an.getNom()+ "','" + an.getPrenom()+ "','"+ms.test1(Glabal.id)+ "','" + ms.test2(Glabal.id) + "','" + an.getType() + "','" + an.getDescription() + "','" + an.getImagee()+ "','" +"en attente"+ "')";
        try {
            ste = cnx.createStatement();
           ste.executeUpdate(req);
          
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  

    }
          public ObservableList<Adoption> read() {
        String req = "select * from `adoption` where Nom_adop='"+ms.test1(Glabal.id).toUpperCase()+"'";
        ObservableList<Adoption> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {

                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
                list.add(new Adoption(rs.getInt("Id_adoption"), rs.getString("Dateann"), rs.getString("nom"), rs.getString("Prenom"), rs.getString("Type"), rs.getString("Description"), rs.getString("Imagee"),rs.getString("Status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
          
           public ObservableList<Adoption> read2() {
        String req = "select * from `adoption` where Nom='"+ms.test2(Glabal.id).toUpperCase()+"'";
        ObservableList<Adoption> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Adoption adop = new Adoption();
                adop.setId_adoption(rs.getInt("Id_adoption"));
                adop.setDateann(rs.getString("Dateann"));
                adop.setNom_adop(rs.getString("Nom_adop"));
                adop.setPrenom_adop(rs.getString("Prenom_adop"));
                adop.setType(rs.getString("type"));
                adop.setDescription(rs.getString("description"));
                adop.setImagee(rs.getString("imagee"));
                adop.setStatus(rs.getString("status"));
                list.add(adop);
                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
               // list.add(new Adoption(rs.getInt("Id_adoption"), rs.getString("Dateann"), rs.getString("Nom_adop"), rs.getString("Prenom_adop"), rs.getString("Type"), rs.getString("Description"), rs.getString("Imagee"),rs.getString("Status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
           
           public Adoption modifierStatuadop(Adoption a) throws SQLException {

            String req2="UPDATE adoption SET `dateann`='"+a.getDateann()+"', `Nom_adop` = '" +a.getNom_adop()+"',`Prenom_adop` = '" +a.getPrenom_adop()+"',`type` = '" +a.getType()+"', `description` = '" +a.getDescription()+"', `imagee`='"+a.getImagee()+"', `status`='"+a.getStatus()+"' where Id_adoption='"+a.getId_adoption()+"';";

              
              try {
            ste = cnx.createStatement();
            ste.executeUpdate(req2);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return a;
      }

}

//          private boolean  verifier(String nom , String prenom ){
//        String req="select * from demande where (nom like '"+nom+"')&&(prenom like '"+prenom+"')" ;
//         return false;
//      
//       
//      
//        
//    }


