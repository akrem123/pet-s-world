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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class EditEventVetController implements Initializable {

    @FXML
    private TextField input_nom_event1;
    @FXML
    private ComboBox<String> combo_event1;
    @FXML
    private DatePicker date_pck_event1;
    @FXML
    private Spinner<Integer> spin_ev1;
    @FXML
    private Spinner<Integer> spin_date1;
    @FXML
    private Button btn_bac;
    @FXML
    private Button btn_ed_vet;
    
    private ImageView img1;

    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String file_image;
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private Button btn_par_edit;
    @FXML
    private ImageView img_v;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         SpinnerValueFactory<Integer> val = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        this.spin_ev1.setValueFactory(val);
        
        SpinnerValueFactory<Integer> val1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        this.spin_date1.setValueFactory(val1);
        
        input_nom_event1.setText(DisplayEventVetController.an.getNomEvent());
        combo_event1.setValue(DisplayEventVetController.an.getCategorieEvent().toString());
        
       //String var = DisplayEventVetController.an.getNbrPlaceDispo();
        System.out.println(spin_ev1);
        System.out.println(DisplayEventVetController.an.getNbrPlaceDispo());
        spin_ev1.getValueFactory().setValue(DisplayEventVetController.an.getNbrPlaceDispo());
        spin_date1.getValueFactory().setValue(DisplayEventVetController.an.getNbrPlaceDispo());
        String vale = DisplayEventVetController.an.getDateEvent();
        date_pck_event1.setValue(LocalDate.parse(vale));
       
        String x = DisplayEventVetController.an.getImage_ev();
         System.out.println(x);
      File file = new File("C:\\Users\\SAIFOUN\\Documents\\NetBeansProjects\\Manage_Event\\src\\main\\java" + x);
// Image image = new Image(file.toURI().toString());
   Image img = new Image(file.toURI().toString());
    img_v.setImage(img);
    } 
    @FXML
    private void parcourir_annonce2(ActionEvent event) {
    FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            img_v.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
}

    @FXML
    private void edition(ActionEvent event) throws IOException {
         LocalDate values = date_pck_event1.getValue();
        String date_event = values.toString();
       
          String nom1 = input_nom_event1.getText();
       String comb1 = combo_event1.getValue().toString();
       //String place = combo_N_places.getValue().toString();
      //  String combb = combo_heure.getValue().toString();
        Integer spin1 = spin_ev1.getValue();
        Integer spin_dat1 = spin_date1.getValue();
         Event p3=new Event(nom1,comb1,spin1,date_event,spin_dat1,file_image);
                p3.setNomEvent(nom1);
                p3.setCategorieEvent(comb1);
                p3.setNbrPlaceDispo(spin1);
                p3.setDateEvent(date_event);
                p3.setHeureDebEvent(spin_dat1);
                p3.setImage_ev(file_image);
                 pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
                
                pathto = FileSystems.getDefault().getPath("C:\\Users\\SAIFOUN\\Documents\\NetBeansProjects\\Manage_Event\\src\\main\\java\\photo" + Current_file.getName());
                Path targetDir = FileSystems.getDefault().getPath("C:\\Users\\SAIFOUN\\Documents\\NetBeansProjects\\Manage_Event\\src\\main\\java\\photo"); 
          
                 Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
            

                EventService es22=new EventService();
                es22.updateEvent(p3,DisplayEventVetController.an.getIdEvent());
         //p.setImage_ev(file_image);
                Parent root;
        try {
            root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/DisplayEventVet.fxml"));
               btn_ed_vet.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }