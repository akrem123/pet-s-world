/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.*;
import Entity.Event;
import Entity.Event;
import Service.EventService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class AjouterEventController implements Initializable {

    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private Button BT_create_event;
    @FXML
    private TextField input4;
    @FXML
    private TextField input6;
    @FXML
    private TextField input7;
    @FXML
    private AnchorPane AnchorPane;

    /**
     * Initializes the controller class.
     */
    
    /*
     private String organisateur;
    private String nom_event;
    private String categorie_event;
    private String date_event;
    private String Lieu;
    private String image;
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        BT_create_event.setOnAction(e->{
        Event p=new Event(input1.getText(),input2.getText(),input3.getText(),input4.getText(),input6.getText(),input7.getText());
         EventService ps=new EventService();
        ps.insert(p);
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterEvent.fxml"));
               BT_create_event.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterEventController.class.getName()).log(Level.SEVERE, null, ex);
    }    
  
       }); 
    }
}

