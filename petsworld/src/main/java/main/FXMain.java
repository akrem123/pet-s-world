package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.regexp.joni.ast.AnchorNode;

/**
 *
 * @author Asus
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherAnnonce.fxml"));
        
        Scene scene = new Scene(root, 800, 800);
        
        primaryStage.setTitle("Ajouter Annonces");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
