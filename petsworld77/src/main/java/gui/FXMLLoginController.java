/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.javafx.applet.Splash;
import entite.Glabal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import service.MembreService;

/**
 * FXML Controller class
 *
 * @author benra
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Button btn;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button btn1;
    @FXML
    private Label alert;
    @FXML
    private Hyperlink fp;

    String v;
    String v1 = "vet";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        btn1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    
//                    btn1.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLSignUp.fxml")));
//                } catch (IOException ex) {
//                    Logger.getLogger(FXMLSignUpController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        ////////////////////////////////////////////////////////////////    
        btn.setOnAction(new EventHandler<ActionEvent>() {
            MembreService ms = new MembreService();

            @Override
            public void handle(ActionEvent event) {
                if (ms.logintest(email.getText(), mdp.getText())) {

                    alert.setText("Membre connecte");
                    System.out.println(Glabal.type);
                    if (Glabal.type.equalsIgnoreCase("user1")) {
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/affichageGlobal.fxml"));
                            btn.getScene().setRoot(root);
                            // btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("affichageGlobal.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                        } }
                        
                        else  if (Glabal.type.equalsIgnoreCase("user2")) {
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/affichageGlobal.fxml"));
                            btn.getScene().setRoot(root);
                            // btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("affichageGlobal.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } else if (Glabal.type.equalsIgnoreCase("Administrator")) {
                        try {

                            btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("affichageGlobal.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    /*
                if(Glabal.type == a) {
                try {
                    
                    btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLEspaceAdmin.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                } 
                }
                     */
                } else {
                    alert.setText("Password or Email is Incorrect");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////    
        fp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    fp.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLRecovery.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
