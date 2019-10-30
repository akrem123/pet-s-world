/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Adoption;
import entite.Glabal;
import static gui.AfficherAnnonceController.an;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
public class ListeAdopController implements Initializable {

    @FXML
    private TableView<Adoption> liste_adpview;
    @FXML
    private ImageView img_3;
    public static Adoption a;
    ObservableList<Adoption> list1 ;
    @FXML
    private Button ret4;
           

    
    public void initialize(URL url, ResourceBundle rb) {
        AnnonceService d5 = new AnnonceService();
        MembreService ms = new MembreService();
        ObservableList<Adoption> list1 = d5.read2();

        TableColumn dateann = new TableColumn("Dateann");
        dateann.setPrefWidth(100);
        dateann.setCellValueFactory(new PropertyValueFactory<>("dateann"));

        TableColumn nom_adop = new TableColumn("Nom_adop");
        nom_adop.setPrefWidth(100);
        nom_adop.setCellValueFactory(new PropertyValueFactory<>("Nom_adop"));

        TableColumn prenom_adop = new TableColumn("prenom_adop");
        prenom_adop.setPrefWidth(100);
        prenom_adop.setCellValueFactory(new PropertyValueFactory<>("Prenom_adop"));

        TableColumn type = new TableColumn("Type");
        type.setPrefWidth(100);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn description = new TableColumn("description");
        description.setPrefWidth(100);
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn Status = new TableColumn("Status");
        Status.setPrefWidth(100);
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        liste_adpview.setItems(list1);
        System.out.println("het l prenom ye ta7foun1 " + list1);
        liste_adpview.getColumns().addAll(dateann, nom_adop, prenom_adop, type, description, Status);
        liste_adpview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        liste_adpview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + liste_adpview.getSelectionModel().getSelectedItem().getImagee());
            Image image1 = new Image(file.toURI().toString());
            img_3.setImage(image1);
            if (newSelection != null) {
                a = newSelection;
            }

            System.out.println(list1);

        });
        // TODO
    }

    @FXML
    private void accepter(ActionEvent event) throws SQLException {
        System.out.println(a.getId_adoption());
        AnnonceService as = new AnnonceService();
        a.setStatus("Accepter");
        Adoption adop = as.modifierStatuadop(a);
        System.out.println(adop.getStatus());

        refreshTable(event);

    }

    @FXML
    private void refuser(ActionEvent event) throws SQLException {
        System.out.println(a.getId_adoption());
        AnnonceService as = new AnnonceService();
        a.setStatus("Refuser");
        Adoption adop = as.modifierStatuadop(a);
        System.out.println(adop.getStatus());
        refreshTable(event);
    }

    private void refreshTable(Event event){
        
        liste_adpview.setItems(null);
        liste_adpview.getColumns().clear();
        AnnonceService as = new AnnonceService();
        ObservableList<Adoption> list1 = as.read2();
        TableColumn dateann = new TableColumn("Dateann");
        dateann.setPrefWidth(100);
        dateann.setCellValueFactory(new PropertyValueFactory<>("dateann"));
        TableColumn nom_adop = new TableColumn("Nom_adop");
        nom_adop.setPrefWidth(100);
        nom_adop.setCellValueFactory(new PropertyValueFactory<>("Nom_adop"));
        TableColumn prenom_adop = new TableColumn("prenom_adop");
        prenom_adop.setPrefWidth(100);
        prenom_adop.setCellValueFactory(new PropertyValueFactory<>("Prenom_adop"));
        TableColumn type = new TableColumn("Type");
        type.setPrefWidth(100);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn description = new TableColumn("description");
        description.setPrefWidth(100);
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn Status = new TableColumn("Status");
        Status.setPrefWidth(100);
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));
        liste_adpview.setItems(list1);
        System.out.println("het l prenom ye ta7foun " + list1);
        liste_adpview.getColumns().addAll(dateann, nom_adop, prenom_adop, type, description, Status);
        liste_adpview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        liste_adpview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            String x = liste_adpview.getSelectionModel().getSelectedItem().getImagee();
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + x);
            Image image1 = new Image(file.toURI().toString());
            img_3.setImage(image1);
            if (newSelection != null) {
                a = newSelection;
            }

            System.out.println(list1);

        });
    }

    @FXML
    private void ret_44(ActionEvent event) {
        
         Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/affichageGlobal.fxml"));
            ret4.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }

