package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       //Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/DisplayEventVet.fxml"));
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/FXMLCHART.fxml"));
         //Display_Users_Event
         //
        Scene scene = new Scene(root, 1000, 1000);
      
        
        
        //Scene scene = new Scene(root);
        //Scene scene = new Scene(root);
        
        primaryStage.setTitle("PETS WORLD");
        //primaryStage.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
                
        //primaryStage.show();
        //primaryStage.hide();
            }
       
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
