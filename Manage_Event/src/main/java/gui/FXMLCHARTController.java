/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.EventService;
import entity.Event;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import util.Datasource;

/**
 * FXML Controller class
 *
 * @author SAIFOUN
 */
public class FXMLCHARTController implements Initializable {

    @FXML
    private PieChart PIE;
    
       private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Event ev;
     ObservableList<PieChart.Data> pieChartData ;
        ArrayList<Integer> cell = new ArrayList<Integer>();
        ArrayList<String> col = new ArrayList<String>();
   
         public FXMLCHARTController() {
        cnx=Datasource.getInstance().getConnection();
    }
        
         public void load(){
             pieChartData = FXCollections.observableArrayList();
             String req="select CategorieEvent,NbrPlaceDispo from events";
             try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                pieChartData.add(new PieChart.Data(rs.getString("CategorieEvent"), rs.getInt("NbrPlaceDispo")));
                cell.add(rs.getInt("NbrPlaceDispo"));
                col.add(rs.getString("CategorieEvent"));
            }
             } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
             
         }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        load();
        PIE.setData(pieChartData);
    }    
    
}
