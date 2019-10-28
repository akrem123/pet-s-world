/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.EventService;
import entity.Event;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class DisplayEventVetController implements Initializable {

    @FXML
    private TableColumn<Event, Integer> C_ID;
    @FXML
    private TableColumn<Event, String> C_Nom;
    @FXML
    private TableColumn<Event, String> C_categ;
    @FXML
    private TableColumn<Event, String> C_nb_place;
    @FXML
    private TableColumn<Event, String> C_date;
    @FXML
    private TableColumn<Event, String> C_heure;
    @FXML
    private TableColumn<Event, String> C_Etat;
    @FXML
    private TableColumn<Event, String> C_organisateur;
    @FXML
    private TableView<Event> table;
    @FXML
    private Button btn_accept_req;
    @FXML
    private Button btn_refuse;
    @FXML
    private ImageView c_image;
    @FXML
    private TableColumn<Event, String> c_pic;
    @FXML
    private CheckBox check1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        EventService ps=new EventService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.readAll();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table.setItems(obs);
        
        C_ID.setCellValueFactory(new PropertyValueFactory<Event,Integer>("IdEvent"));
        C_Nom.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C_categ.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C_nb_place.setCellValueFactory(new PropertyValueFactory<Event,String>("NbrPlaceDispo"));
        C_date.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C_heure.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));
        C_Etat.setCellValueFactory(new PropertyValueFactory<Event,String>("Etat"));
        C_organisateur.setCellValueFactory(new PropertyValueFactory<Event,String>("organisateur"));
        c_pic.setCellValueFactory(new PropertyValueFactory<Event,String>("image_ev"));
        
       // table.setOnMouseClicked((javafx.scene.input.MouseEvent event)->
           table.setOnMouseClicked((javafx.scene.input.MouseEvent event)->     
        {
         String x =table.getSelectionModel().getSelectedItem().getImage_ev();
         File file= new File("C:\\Users\\SAIFOUN\\Documents\\NetBeansProjects\\Manage_Event\\src\\main\\java\\photo"+ x);
         Image img = new Image(file.toURI().toString());
         c_image.setImage(img);
        });
         btn_accept_req.setOnAction(e->{
    EventService psb=new EventService();
        psb.updateEvent(table.getSelectionModel().getSelectedItem().getIdEvent());
        Parent root;
              try {
                  root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/DisplayEventVet.fxml"));
                  btn_accept_req.getScene().setRoot(root);
              } catch (IOException ex) {
                  Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
              }
        
   });
         btn_refuse.setOnAction(e->{
    EventService psb=new EventService();
        psb.supprimer(table.getSelectionModel().getSelectedItem().getIdEvent());
        Parent root;
       
              try {
                  root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/DisplayEventVet.fxml"));
                  btn_refuse.getScene().setRoot(root);
              } catch (IOException ex) {
                  Logger.getLogger(AddEventVetController.class.getName()).log(Level.SEVERE, null, ex);
              }
        
   });
 
         
       
        //coldesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        // TODO
    }    
    
}
