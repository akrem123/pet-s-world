/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.EventService;
import entity.Event;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class AddeventCoiffeurController implements Initializable {

    @FXML
    private TextField input_nom_event1;
    @FXML
    private ComboBox<String> combo_event1;
     ObservableList<String> options1 = FXCollections.observableArrayList("EVENT1", "EVENT2","EVENT3");
   
    @FXML
    private Button btn_add_coiffeur;
    @FXML
    private DatePicker date_pck_event1;
    @FXML
    private Spinner<Integer> spin_coif;
    @FXML
    private Spinner<Integer> spin_coif_heure;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         combo_event1.setItems(options1);
        
         
         
          SpinnerValueFactory<Integer> val = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        this.spin_coif.setValueFactory(val);
        
        SpinnerValueFactory<Integer> val2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 23);
        this.spin_coif_heure.setValueFactory(val2);
        
        
         btn_add_coiffeur.setOnAction(e->{
         LocalDate values = date_pck_event1.getValue();
        String date_event = values.toString();
       // Event ev = new Event(input_nom_event.getText(), date_event);
        //Event ev = new Event(input_nom_event.getText(),combo_event.getValue().toString(),spin_nbr.getValue(),date_event,sping_heure_deb.getValue());
         Event p=new Event(input_nom_event1.getText(),combo_event1.getValue().toString(),spin_coif.getValue(),date_event,spin_coif_heure.getValue());
        EventService ps=new EventService();
        ps.insertEventCoiff(p);
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AddEventVet.fxml"));
               btn_add_coiffeur.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });   
    
        
        
        
        
        
        
        
        
        
        // TODO
    }    
    
}
