/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author benra
 */
public class Animal {
    
    protected int id;
    protected String nom;
    protected String espece;
    protected String race;
    protected String birthdate;
    protected String gender;
    protected int taille;
    protected int poids;
    
    private List<Membre> membres;
    
    public Animal(){
    }

    
    
    public Animal(String nom, String espece, String race, String birthdate, String gender, int taille, int poids) {
        this.nom = nom;
        this.espece = espece;
        this.race = race;
        this.birthdate = birthdate;
        this.gender = gender;
        this.taille = taille;
        this.poids = poids;
    }

    public Animal(int id, String nom, String espece, String race, String birthdate, String gender, int taille, int poids) {
        this.id = id;
        this.nom = nom;
        this.espece = espece;
        this.race = race;
        this.birthdate = birthdate;
        this.gender = gender;
        this.taille = taille;
        this.poids = poids;
    }

    
    

    public int getId() {
        return id;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
    
}
