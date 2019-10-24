/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PI;

import Entity.Event;
import Service.EventService;

/**
 *
 * @author SAIFOUN
 */
public class Pi_main {
    public static void main(String[] args) {
    Event p = new Event("saif","LAB GAME","GAMING","today","esprit","image.jpg");
    
       EventService es =new EventService();
       es.insert(p);
      es.readAll();
             
       //es.insert(p);
         //EventService psa =new EventService();
        //psa.supprimer(8);
      // System.out.println(es.readAll());
      // es.modifier(5,"saif","SEASON2.0","GAMING");
       System.out.println(es.readAll());
       /*
        System.out.println("CHERCHER ");
        System.out.println(es.search(5));
         System.out.println(es.readAll());
*/
    
}
}