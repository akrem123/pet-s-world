/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Glabal;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.MembreService;
import services.Mailer;

/**
 * FXML Controller class
 *
 * @author benra
 */
public class FXMLSignUpController implements Initializable {

    
    @FXML
    private Button btn;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField mdp;
    @FXML
    private TextField rmdp;
    @FXML
    private TextField cin;
    @FXML
    private Label alert;
    @FXML
    private Button hyp4;
    @FXML
    private ComboBox combo;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        combo.getItems().addAll(
            "Client",
            "Veterinary",
            "Hair Dresser",
            "Administrator" );
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            MembreService ms = new MembreService();
            
           if(prenom.getText().length()<21&&prenom.getText().length()>2){ 
           if(nom.getText().length()<21&&nom.getText().length()>2){              
           if(verifmail(email.getText())){
           if(cin.getText().length()==8&&Glabal.isInteger(cin.getText())){
           if(mdp.getText().length()<21&&mdp.getText().length()>7){
           if(mdp.getText().equals(rmdp.getText())){
           if(ms.emailexist(email.getText())&&ms.emailexist(email.getText())){
                Glabal.globalprenom=prenom.getText();
                Glabal.globalcin=Integer.parseInt(cin.getText());
                Glabal.globalnom=nom.getText();
                Glabal.globalemail=email.getText();
                Glabal.globalmdp=mdp.getText();
                Glabal.type=(String) combo.getValue();
                try {
                    btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLVerifm.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Mailer em=new Mailer();
                Random r = new Random();
                int alea = 100000 + r.nextInt(999999 - 100000);
                Glabal.globalcodeins=alea;
                em.sendmail(email.getText(),alea);
                
           }
           else{
            alert.setText("Existent Email");   
           }
           }
           else{
            alert.setText("Password don't match");   
           }
           }
           else{
             alert.setText("Password size is wrong (8,25)");  
           }
           }
           else{
            alert.setText("Cin is wrong(8)");   
           }
           }
           else{
            alert.setText("E-mail wrong (eg..@domaine.domaine)");   
           }
           }
           else{
            alert.setText("Name size is wrong (3,20)");   
           }
           }
           else{
            alert.setText("First Name size is wrong (3,20)");   
           }
           
            }
         });
        
        
        
        
        hyp4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    hyp4.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLLogin.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }    
    
    private boolean verifmail(String email){
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._]{2,25}+@[A-Z]{5,10}+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher=VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (matcher.matches())
                return true;
        return false;
    }
    
}
