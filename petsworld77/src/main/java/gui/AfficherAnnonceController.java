/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import entite.Demande;
import entite.Glabal;
import java.io.File;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import service.AnnonceService;
import service.MembreService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AfficherAnnonceController implements Initializable {

    @FXML
    private TableView<Demande> tableannonce;
    @FXML
    private Button btnsupp1;
    @FXML
    private Button btnajout2;
    @FXML
    private Button modifid1;
    @FXML
    private TextField txtchercher;
    @FXML
    private ImageView imgView;
    public static ObservableList<Demande> dem;
    AnnonceService d6 = new AnnonceService();
    public static Demande an;
    @FXML
    private Button retour22;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        AnnonceService d5 = new AnnonceService();
        MembreService ms = new MembreService();

        ObservableList<Demande> list1 = d5.readAll2();
        System.out.println("affff ammmmmiiin "+ms.test2(Glabal.id).toUpperCase());
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
        });

//        tableannonce.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{
        btnajout2.setOnAction(e -> {
            Parent root;

            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterAnnonce.fxml"));
                btnajout2.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btnsupp1.setOnAction(e -> {

            AnnonceService d7 = new AnnonceService();
            d7.supprimer(tableannonce.getSelectionModel().getSelectedItem().getNumero());

            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
                btnsupp1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void chercher_ann(KeyEvent event) {

        AnnonceService an = new AnnonceService();
        String msg = txtchercher.getText().concat("%");
        ArrayList<Demande> d = (ArrayList<Demande>) an.chercher(msg);
        ObservableList<Demande> obs = FXCollections.observableArrayList(d);
        tableannonce.setItems(obs);
    }

    @FXML
    private void modifier_annonce(ActionEvent event) throws IOException {

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/modifierAnnonce.fxml"));
            modifid1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void retour_22(ActionEvent event) {

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/affichageGlobal.fxml"));
            modifid1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
