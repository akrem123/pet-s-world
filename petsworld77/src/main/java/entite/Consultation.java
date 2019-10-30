/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;

/**
 *
 * @author benra
 */
public class Consultation {
    
    private int id;
    private String sujet;
    private String type;
    private String description;
    private String etat;
    private String date;
    private String debut;
    private String fin;
    
    private List<Animal> animals;
    
    public Consultation(){
    }

    public Consultation(int id, String sujet, String type, String description, String date, String debut, String fin) {
        this.id = id;
        this.sujet = sujet;
        this.type = type;
        this.description = description;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
    }

    public Consultation(String sujet, String type, String description, String date, String debut, String fin) {
        this.sujet = sujet;
        this.type = type;
        this.description = description;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
    }

    public Consultation(int id, String sujet, String type, String description, String etat, String date, String debut, String fin) {
        this.id = id;
        this.sujet = sujet;
        this.type = type;
        this.description = description;
        this.etat = etat;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
    }

    public Consultation(String sujet, String type, String description, String date, String debut, String fin, String etat) {
        this.sujet = sujet;
        this.type = type;
        this.description = description;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
        this.etat = etat;
    }

    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    

    
    
 
    
    
}
