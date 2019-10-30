/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Adoption;
import entite.Demande;
import entite.Glabal;
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
import service.AnnonceService;
import service.MembreService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AffichageGlobalController implements Initializable {

    @FXML
    private TableView<Demande> tableannonce;
    @FXML
    private Button btnadopter;
    @FXML
    private ImageView imgView;
    @FXML
    private Button dirannonce;
    AnnonceService d6 = new AnnonceService();
    private Label label1;
    private Label label2;
    @FXML
    private Label label99;
    Adoption a = new Adoption();
    @FXML
    private Button demande_adp1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AnnonceService d5 = new AnnonceService();
//        MembreService ms = new MembreService();
//        label1.setText(ms.test1(Glabal.id));
//        label2.setText(ms.test2(Glabal.id));
        ObservableList<Demande> list1 = d5.readAll();
//        ArrayList<Demande> d6 = (ArrayList<Demande>) d5.readAll();
////        ObservableList<Demande> obs = FXCollections.observableArrayList(d6);
//        tableannonce.setItems(obs);
//        
        TableColumn date = new TableColumn("Dateann");
        date.setPrefWidth(100);
        date.setCellValueFactory(new PropertyValueFactory<>("Dateann"));

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

        TableColumn image = new TableColumn("imagee");
        image.setPrefWidth(100);
        image.setCellValueFactory(new PropertyValueFactory<>("imagee"));

//        coldate.setCellValueFactory(new PropertyValueFactory<Demande, String>("dateann"));
//        colnom.setCellValueFactory(new PropertyValueFactory<Demande, String>("nom"));
//        colprenom.setCellValueFactory(new PropertyValueFactory<Demande, String>("prenom"));
//        coltitre.setCellValueFactory(new PropertyValueFactory<Demande, String>("type"));
//        coldescription.setCellValueFactory(new PropertyValueFactory<Demande, String>("description"));
//        idpic.setCellValueFactory(new PropertyValueFactory<Demande, String>("imagee"));
//       
        tableannonce.setItems(list1);
        tableannonce.getColumns().addAll(date, nom, prenom, type, description, image);
        tableannonce.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableannonce.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            String x = tableannonce.getSelectionModel().getSelectedItem().getImagee();
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + x);
            Image image1 = new Image(file.toURI().toString());
            imgView.setImage(image1);

            System.out.println(list1);
            System.out.println(newSelection);
            if (newSelection != null) {
                an = newSelection;
            }
            btnadopter.setOnAction(e->{
            d6.insertAdop(a);
            a.setStatus("en attente");
            Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/panierAdoption.fxml"));
            btnadopter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }});
            
        });
        // TODO
    }

    @FXML
    private void dir_aff(ActionEvent event) {

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
            dirannonce.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @FXML
    private void panier(ActionEvent event) {
         Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/panierAdoption.fxml"));
            dirannonce.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void dir_demadop(ActionEvent event) {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/listeAdop.fxml"));
            dirannonce.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichageGlobalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
