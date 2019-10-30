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
public class Membre extends User {
    
    private String prenom;
    private int cin;
    private String phone;
    private String adress;
    private String city;

   
    public Membre() {
    }

    public Membre(String email, String mdp) {
        super(email, mdp);
    }

    public Membre(String prenom, int cin, String nom, String email, String mdp) {
        super(nom, email, mdp);
        this.prenom = prenom;
        this.cin = cin;
    }

    public Membre(String nom, String prenom, String email, int cin) {
        super(nom, email);
        this.prenom = prenom;
        this.cin = cin;
    }

    public Membre(String prenom, String nom, String email, String mdp) {
        super(nom, email, mdp);
        this.prenom = prenom;
    }

    public Membre(String type, int id, String email, String mdp) {
        super(id, email, mdp);
        super.type = type;
    }
    
    public Membre(String prenom, String nom , int cin, String mdp){
        super.nom=nom;
        super.mdp=mdp;
        this.cin=cin;
        this.prenom=prenom;
    } 
    
    public Membre(int id, String email , String mdp, String type){
        super.id=id;
        super.email=email;
        this.mdp=mdp;
        this.type=type;
    } 
    
    public Membre(String nom, String prenom, String email , String mdp, int cin){
        super.nom=nom;
        super.email=email;
        super.mdp=mdp;
        this.cin=cin;
        this.prenom=prenom;
    } 
    
    public Membre(int id, String nom, String prenom, String email , String mdp, int cin){
        super.id=id;
        super.nom=nom;
        super.email=email;
        super.mdp=mdp;
        this.cin=cin;
        this.prenom=prenom;
    } 
    
    public Membre(String nom, String prenom, String email , String mdp, int cin, String type){
        super.nom=nom;
        super.email=email;
        super.mdp=mdp;
        super.type=type;
        this.cin=cin;
        this.prenom=prenom;
    } 
    
    public Membre(int id, String nom, String prenom, String email , String mdp, int cin, String phone, String adress, String city){
        super.id=id;
        super.nom=nom;
        this.prenom=prenom;
        super.email=email;
        super.mdp=mdp;
        this.cin=cin;
        super.type=type;
        this.phone=phone;
        this.adress=adress;
        this.city=city;
    } 
    
    

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    

    
    
    
    
    
}
