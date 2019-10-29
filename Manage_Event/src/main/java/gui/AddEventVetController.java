/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.EventService;
import entity.Event;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class AddEventVetController implements Initializable {

    @FXML
    private TextField input_nom_event;
    @FXML
    private DatePicker date_pck_event;
    @FXML
    private Button btn_add_vet;
    @FXML
    private ComboBox<String> combo_event;
    ObservableList<String> options = FXCollections.observableArrayList("Tournoi", "Fete","Journée","Festival");
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
    @FXML
    private Spinner<Integer> spin_ev;
    @FXML
    private Spinner<Integer> spin_date;
    @FXML
    private Button btn_bac;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_event.setItems(options);
        //combo_N_places.setItems(nbr);
       // combo_heure.setItems(temp);
        
        SpinnerValueFactory<Integer> val = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        this.spin_ev.setValueFactory(val);
        
        SpinnerValueFactory<Integer> val2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        this.spin_date.setValueFactory(val2);
     
         btn_bac.setOnAction(e->{
        Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Login.fxml"));
                    btn_bac.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
       
 
     btn_add_vet.setOnAction(e->{
         LocalDate value = date_pck_event.getValue();
        String date_event = value.toString();
       // Event ev = new Event(input_nom_event.getText(), date_event);
        //Event ev = new Event(input_nom_event.getText(),combo_event.getValue().toString(),spin_nbr.getValue(),date_event,sping_heure_deb.getValue());
      
           String nom = input_nom_event.getText();
       String comb = combo_event.getValue().toString();
       //String place = combo_N_places.getValue().toString();
      //  String combb = combo_heure.getValue().toString();
        Integer spin = spin_ev.getValue();
        Integer spin_dat = spin_date.getValue();
         Event p=new Event(nom);
        EventService psa=new EventService();
        if(nom.isEmpty() || spin.equals(0)|| comb.isEmpty() || spin_dat.equals(0) )
             {
                  Alert alert =new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid input");
                alert.setHeaderText(null);
                alert.setContentText("Un champ manquant !!  Veillez remplir les champs");
                alert.showAndWait();
             }
             else{
            {
                
                Event dx = new Event();
                
                dx.setNomEvent(nom);
                dx.setCategorieEvent(comb);
                dx.setNbrPlaceDispo(spin);
                dx.setDateEvent(date_event);
                dx.setHeureDebEvent(spin_dat);
                dx.setImage_ev(file_image);
                
                //Event p=new Event(input_nom_event.getText(),combo_event.getValue().toString(),combo_N_places.getValue().toString(),date_event,combo_heure.getValue().toString(),file_image);
                pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
                
                pathto = FileSystems.getDefault().getPath("C:\\Users\\SAIFOUN\\Documents\\NetBeansProjects\\Manage_Event\\src\\main\\java\\photo" + Current_file.getName());
                Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\SAIFOUN\\Documents\\NetBeansProjects\\Manage_Event\\src\\main\\java\\photo");
                try {
                    Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //  Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
                EventService ps=new EventService();
                ps.insertEventVet(dx);
                Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/DisplayEventVet.fxml"));
                    btn_add_vet.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
   
     });

    
    /*
    
    @FXML
    private void AddEvent_VETERINAIRE(ActionEvent event) {
         String nom_event = input_nom_event.getText();
       String combo = combo_event.getValue().toString();
       Integer spin1 = spin_nbr.getValue();
       LocalDate value = date_pck_event.getValue();
        String date_event = value.toString();
        Integer spin2 = sping_heure_deb.getValue();
        
         Event d = new Event();
        d.setNomEvent(nom_event);
        d.setCategorieEvent(combo);
        d.setNbrPlaceDispo(spin1);
        d.setDateEvent(date_event);
        d.setHeureDebEvent(spin2);
        
        EventService es = new EventService();
         
            es.insertEventVet(d);
            
            
                Parent root;

            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("AddEventVet.fxml"));
                btn_add_vet.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
*/
    
}
    /*                         button retour      /////////////////////////////////**************************
     btn_bac.setOnAction(e->{
        Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AddeventCoiffeur.fxml"));
                    bt_aller_coif.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }    
*/
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
                Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}