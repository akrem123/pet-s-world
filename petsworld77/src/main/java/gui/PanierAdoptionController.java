/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Adoption;
import entite.Demande;
import static gui.AfficherAnnonceController.an;
import gui.AjouterAnnonceController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.AnnonceService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PanierAdoptionController implements Initializable {

    @FXML
    private TableView<Adoption> panier_aff;
    @FXML
    private Button ret;
    @FXML
    private ImageView imgView1;
    @FXML
    private Label label_dem;
    @FXML
    private Button sup_2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AnnonceService d5 = new AnnonceService();

        ObservableList<Adoption> list1 = d5.read();
//        ArrayList<Demande> d6 = (ArrayList<Demande>) d5.readAll();
////        ObservableList<Demande> obs = FXCollections.observableArrayList(d6);
//        tableannonce.setItems(obs);
//        
        TableColumn dateann = new TableColumn("Dateann");
        dateann.setPrefWidth(100);
        dateann.setCellValueFactory(new PropertyValueFactory<>("Dateann"));

        TableColumn nom = new TableColumn("Nom");
        nom.setPrefWidth(100);
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));

        TableColumn prenom = new TableColumn("Prenom");
        prenom.setPrefWidth(100);
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));

        TableColumn type = new TableColumn("Type");
        type.setPrefWidth(100);
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));

        TableColumn description = new TableColumn("Description");
        description.setPrefWidth(100);
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));

//        TableColumn imagee = new TableColumn("Imagee");
//        imagee.setPrefWidth(100);
//        imagee.setCellValueFactory(new PropertyValueFactory<>("Imagee"));
        
        TableColumn Status = new TableColumn("Status");
        Status.setPrefWidth(100);
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

//        coldate.setCellValueFactory(new PropertyValueFactory<Demande, String>("dateann"));
//        colnom.setCellValueFactory(new PropertyValueFactory<Demande, String>("nom"));
//        colprenom.setCellValueFactory(new PropertyValueFactory<Demande, String>("prenom"));
//        coltitre.setCellValueFactory(new PropertyValueFactory<Demande, String>("type"));
//        coldescription.setCellValueFactory(new PropertyValueFactory<Demande, String>("description"));
//        idpic.setCellValueFactory(new PropertyValueFactory<Demande, String>("imagee"));
//       
          panier_aff.setItems(list1);
          panier_aff.getColumns().addAll(dateann, nom, prenom, type, description,Status);
          panier_aff.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
          panier_aff.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            String x = panier_aff.getSelectionModel().getSelectedItem().getImagee();
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + x);
            Image image1 = new Image(file.toURI().toString());
            imgView1.setImage(image1);

            System.out.println(list1);
            
        });
          
//          sup_2.setOnAction(e -> {
//            
//            AnnonceService d7 = new AnnonceService();
//            d7.supprimer(panier_aff.getSelectionModel().getSelectedItem().getNumero());
//            
//            Parent root;
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/panierAdoption.fxml"));
//                sup_2.getScene().setRoot(root);
//            } catch (IOException ex) {
//                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        });
//    
        // TODO
    }
        // TODO

    @FXML
    private void retour_aff(ActionEvent event) {
        Parent root;

            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/affichageGlobal.fxml"));
                ret.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        
    }

   
         
    

}
