/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Demande;
import entite.Glabal;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import service.AnnonceService;
import service.MembreService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ModifierAnnonceController implements Initializable {

    private TextField txtnom11;
    private TextField txtprenom11;
    @FXML
    private DatePicker date11;
    @FXML
    private ComboBox<String> combo11;
    @FXML
    private TextArea desc11;
    @FXML
    private Button ajouter11;
     ObservableList<String> options = FXCollections.observableArrayList("Perte", "Adoption");
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private ImageView img_view22;
    @FXML
    private Button parc_33;
    
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
        // TODO
          // label1.setText(ms.test1(Glabal.id));
          combo11.setItems(options);
//          AnnonceService an = new AnnonceService();
        MembreService ms = new MembreService();
        label5.setText(ms.test1(Glabal.id));
        label6.setText(ms.test2(Glabal.id));
//        String nom = label5.getText();
//        String prenom = label6.getText();
        
          String date88 =AfficherAnnonceController.an.getDateann();
//        LocalDate value = date11.getValue();
//        String dateSS = value.toString();        
//        txtDate.set(AfficherAnnonceController.an.getDateann());
//         d.setDateann(dateSS);
          date11.setValue(LocalDate.parse(date88));
        
          
         //LocalDate value = AfficherAnnonceController.an.getDateann();
       // String date22 = value.toString();
       
     

        combo11.setValue(AfficherAnnonceController.an.getType());
//        date11.seAfficherAnnonceController.an.);
//        date11.setDate22
       desc11.setText(AfficherAnnonceController.an.getDescription());
    }    

    @FXML
    private void modifier_off(ActionEvent event) throws IOException {
        
        
          
       LocalDate value = date11.getValue();
        String dateSS = value.toString();
        String desc = desc11.getText();
        String com = combo11.getValue();
      
      
        
        
        Demande d = new Demande(dateSS,com,desc,file_image);
        d.setDateann(dateSS);
        //d.setNom(nom);
        //d.setPrenom(prenom);
        d.setType(com);
        d.setDescription(desc);
    
        d.setImagee(file_image);
      
       
        
        
        
         pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());

        pathto = FileSystems.getDefault().getPath("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\Asus\\Documents\\NetBeansProjects\\petsworld\\src\\main\\java\\photos");
        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        AnnonceService an = new AnnonceService();
        
        an.modifier33(AfficherAnnonceController.an.getNumero(), d);
       // an.modifier(AfficherAnnonceController.an.getNumero(),dateSS, combo11.getValue(),desc11.getText());
        
         Parent root;

            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
                ajouter11.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void parcourir_2(ActionEvent event) {
        
        
         FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            img_view22.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    
 
    
}
