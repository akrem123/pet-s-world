/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class LoginController implements Initializable {

    @FXML
    private Button bt_aller_vet;
    @FXML
    private Button bt_aller_coif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bt_aller_vet.setOnAction(e->{
        Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AddEventVet.fxml"));
                    bt_aller_vet.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
 
        
        // TODO
         bt_aller_coif.setOnAction(e->{
        Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AddeventCoiffeur.fxml"));
                    bt_aller_coif.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }    
    
}
