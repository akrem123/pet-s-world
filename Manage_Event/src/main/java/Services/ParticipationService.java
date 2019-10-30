package Services;

import entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Datasource;


/**
 *
 * @author SAIFOUN
 */
public class ParticipationService {
    
    
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Event ev;
    
    public ParticipationService() {
        cnx=Datasource.getInstance().getConnection();
    }
     public void insertPart(String NomEvent){
        String req="insert into participate(Name) values ('"+NomEvent+")";
       
        try {
            ste= cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
}