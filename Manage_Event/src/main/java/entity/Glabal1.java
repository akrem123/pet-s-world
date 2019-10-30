/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author benra
 */
public class Glabal1 {
    
    public static int id;
    public static String anom;
    public static String espece;
    public static String race;
    public static String birthdate;
    public static String gender;
    public static int taille;
    public static int poids;
    
    
    public static boolean isInteger(Object object) {
	if(object instanceof Integer) {
		return true;
	} else {
		String string = object.toString();
		
		try {
			Integer.parseInt(string);
		} catch(Exception e) {
			return false;
		}	
	}
  
    return true;
}
}
