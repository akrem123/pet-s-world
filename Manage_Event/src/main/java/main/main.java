/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Services.EventService;
import entity.Event;

/**
 *
 * @author SAIFOUN
 */
public class main {
     public static void main(String[] args) {
         EventService es =new EventService();
         //Event ev = new Event("Event_Top", "GAMING",20,"2019-10-17",20);
         //Event ev = new Event("NomEvent", "CategorieEvent","5","2");
         
         EventService es1 =new EventService();
        // Event ev  = new Event("NomEvent", "NbrPlaceDispo"," DateEvent", "eureDebEvent");
         //es.readByNomEvent("NomEvent");
         
        /// es.insertEvent(ev);
        // es.insertEvent2(ev);
         //System.out.println( es.readByNomEvent("NomEvent"));
        
     }
    
}
