/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entite.Demande;
import util.DataSource;
import service.AnnonceService;

/**
 *
 * @author Asus
 */
public class Main {
    
    
      public static void main(String[] args) {
        // TODO code application logic here
        DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);
          AnnonceService d1 = new AnnonceService();
       Demande d = new Demande("2019-10-29", "sessi","aaa","bbb","ppp");
        d1.insert(d);
        
        
           AnnonceService d2 =new AnnonceService();
       
        //d2.supprimer(4);
       
       // d2.modifier(8,"hhy","jh","ghjghj","gkgj","vghg","ggghj");
        
         System.out.println(d1.readAll());
         //System.out.println(d2.chercher(11));
}
}
