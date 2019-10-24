/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import entite.Demande;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import service.AnnonceService;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AfficherAnnonceController implements Initializable {

    @FXML
    private TableView<Demande> tableannonce;
    @FXML
    private TableColumn<Demande, String> coldate;
    @FXML
    private TableColumn<Demande, String> colnom;
    @FXML
    private TableColumn<Demande, String> colprenom;
    @FXML
    private TableColumn<Demande, String> coltitre;
    @FXML
    private TableColumn<Demande, String> coldescription;
    @FXML
    private Button btnsupp1;
    @FXML
    private Button btnajout2;
    @FXML
    private TableColumn<Demande, String> idpic;
    @FXML
    private Button modifid1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
           AnnonceService d5=new AnnonceService();
        ArrayList<Demande> d6=(ArrayList<Demande>) d5.readAll();
        ObservableList<Demande> obs=FXCollections.observableArrayList(d6);
        tableannonce.setItems(obs);
        
        coldate.setCellValueFactory(new PropertyValueFactory<Demande, String>("dateann"));
        colnom.setCellValueFactory(new PropertyValueFactory<Demande, String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Demande, String>("prenom"));
        coltitre.setCellValueFactory(new PropertyValueFactory<Demande, String>("type"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Demande, String>("description"));
        idpic.setCellValueFactory(new PropertyValueFactory<Demande, String>("imagee"));
       // immid.setImage("../photos/aa2.jpg");
       //immid.setImage(FileSystems.getDefault().getPath("../photos/aa2.jpg"));
        
   btnajout2.setOnAction(e->{
       Parent root;
   
  try {
            root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterAnnonce.fxml"));
               btnajout2.getScene().setRoot(root);
 } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
   } );
   
   btnsupp1.setOnAction(e->{
      
      AnnonceService d7=new AnnonceService();
      d7.supprimer(tableannonce.getSelectionModel().getSelectedItem().getNumero());
        
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
               btnsupp1.getScene().setRoot(root);
 } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
           });}

    @FXML
    private void afficher_anchor(ActionEvent event) {
        
        
        
        
    }
}
    
    
         
    
    

