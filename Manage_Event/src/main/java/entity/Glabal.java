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
public class Glabal {
    public static int globalcoderec;
    public static int globalid;
    public static String globalnom;
    public static String globalemail;
    public static String globalmdp;
    public static String globalprenom;
    public static int globalcin;
    public static int globalcodeins;
    public static String globalemailrec;
    public static int id;
    public static String type;
    
    
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
