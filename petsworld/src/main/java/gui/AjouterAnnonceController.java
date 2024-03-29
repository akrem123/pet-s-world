/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Demande;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.AnnonceService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AjouterAnnonceController implements Initializable {

    @FXML
    private DatePicker txtdate;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextArea txtdescription;
    @FXML
    private ComboBox<String> combotype;
    @FXML
    private Button btnajout1;
    ObservableList<String> options = FXCollections.observableArrayList("Perte", "Adoption");
    @FXML
    private Button parcourir1;
    @FXML
    private ImageView img1;

    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  combotype.setItems(options);
   
//        
//        btnajout1.setOnAction(e -> {
//
//            
//
//            //Demande d=new Demande (txtdate.getText(),txtnom.getText(),txtprenom.getText(),txttitre.getText(),txtdescription.getText());
//            Demande d = new Demande(dateS, txtnom.getText(), txtprenom.getText(), combotype.getValue(), txtdescription.getText());
//            d.setImagee(file_image);
//
//            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
//
//            pathto = FileSystems.getDefault().getPath("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + Current_file.getName());
//            Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos");
//            try {
//                Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
//            } catch (IOException ex) {
//                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            AnnonceService d5 = new AnnonceService();
//            d5.insert(d);
//            Parent root;
//
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
//                btnajout1.getScene().setRoot(root);
//            } catch (IOException ex) {
//                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//
//        parcourir1.setOnAction(e -> {
//
//        });
    }



    @FXML
    private void ajouterannonce(ActionEvent event) throws IOException {
        
        String nom = txtnom.getText();
        String prenom = txtprenom.getText();
       LocalDate value = txtdate.getValue();
        String dateS = value.toString();
        String desc = txtdescription.getText();
        String com = combotype.getValue().toString();
      
      
        
        
        Demande d = new Demande();
        d.setDateann(dateS);
        d.setNom(nom);
        d.setPrenom(prenom);
        d.setType(com);
        d.setDescription(desc);
    
        d.setImagee(file_image);
       
      
        
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());

        pathto = FileSystems.getDefault().getPath("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos");
        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        
        AnnonceService d5 = new AnnonceService();
          d5.insert(d);
//            LocalDate value2 = txtdate.getValue();
//        String date2 = value2.toString();
//            
//            if(txtdate.getValue().equals("")){
//                
//                Alert alert =new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Invalid input");
//                alert.setHeaderText(null);
//                alert.setContentText("champ date est vide");
//                alert.showAndWait();
//            }
//            else
//            {
//                d5.insert(d);
//            Alert a =new Alert(null, "ajout fait avec succes",ButtonType.CLOSE);
//            a.showAndWait();
//            
              Parent root;

            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
                btnajout1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
              
        
             
           
       
    }
    
        @FXML
    private void parcourir_annonce(ActionEvent event) {

        FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            img1.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

// TODO

