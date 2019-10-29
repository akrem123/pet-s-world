/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.EventService;
import Services.ParticipationService;
import entity.Event;
import entity.Participation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class Display_Users_EventController implements Initializable {

    @FXML
    private TableColumn<Event, String> C1_Name_Ev;
    @FXML
    private TableColumn<Event, String> C2_cat_event;
    @FXML
    private TableColumn<Event, String> C3_date_EV;
    @FXML
    private TableColumn<Event, String> C4_H_Debt;
    @FXML
    private Button btn_Participe;
    @FXML
    private TableView<Event> table_us;
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    
   int ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.readAll2();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));  
        
        
        btn_Participe.setOnAction(e->{
            
            EventService ee = new EventService();
            
          // Event eee = new Event(table_us.getSelectionModel().getSelectedItem().getIdEvent());
           int idd= table_us.getSelectionModel().getSelectedItem().getIdEvent();
            System.out.println(idd);
          
            Participation p = new Participation(1, idd);
            
            //Jassem USER ID 
            ee.participe(p);
            
         
        
    });
    }    
    @FXML
    private void FILTER(ActionEvent event) {
      if(check1.isSelected()){
          check2.setSelected(false);
          check3.setSelected(false);
          check4.setSelected(false);
              EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.filterC1();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));
      }
      else
      {
       
        EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.readAll2();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));   
        
    }
   }

    @FXML
    private void filter2(ActionEvent event) {
         if(check2.isSelected()){
              check3.setSelected(false);
          check4.setSelected(false);
          check1.setSelected(false);
              EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.filterC2();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));
        
    }
          else
      {
       
        EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.readAll2();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));   
        
    }
    }
    @FXML
    private void filter3(ActionEvent event) {
        if(check3.isSelected()){
             check2.setSelected(false);
          check1.setSelected(false);
          check4.setSelected(false);
              EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.filterC3();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));
    }
          else
      {
       
        EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.readAll2();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));   
        
    }
    }

    @FXML
    private void filter4(ActionEvent event) {
        if(check4.isSelected()){
             check2.setSelected(false);
          check3.setSelected(false);
          check1.setSelected(false);
              EventService ps=new EventService();
          //ParticipationService psa=new ParticipationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.filterC4();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));
    }
          else
      {
       
        EventService ps=new EventService();
          //ParticipationService psa=new Partici nhpationService();
        ArrayList<Event> pers=(ArrayList<Event>) ps.readAll2();
        ObservableList<Event> obs =FXCollections.observableArrayList(pers);
        table_us.setItems(obs);
        
        C1_Name_Ev.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
        C2_cat_event.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
        C3_date_EV.setCellValueFactory(new PropertyValueFactory<Event,String>("DateEvent"));
        C4_H_Debt.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureDebEvent"));   
        
    }
    }
    
     
    
    
    
}

