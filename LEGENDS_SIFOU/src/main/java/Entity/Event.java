/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author SAIFOUN
 */
public class Event {
    private String organisateur;
    private String nom_event;
    private String categorie_event;
    private String date_event;
    private String Lieu;
    private String image;

    public Event(String organisateur, String nom_event, String categorie_event, String date_event, String Lieu, String image) {
        this.organisateur = organisateur;
        this.nom_event = nom_event;
        this.categorie_event = categorie_event;
        this.date_event = date_event;
        this.Lieu = Lieu;
        this.image = image;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public String getNom_event() {
        return nom_event;
    }

    public String getCategorie_event() {
        return categorie_event;
    }

    public String getDate_event() {
        return date_event;
    }

    public String getLieu() {
        return Lieu;
    }

    public String getImage() {
        return image;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setCategorie_event(String categorie_event) {
        this.categorie_event = categorie_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.organisateur, other.organisateur)) {
            return false;
        }
        if (!Objects.equals(this.nom_event, other.nom_event)) {
            return false;
        }
        if (!Objects.equals(this.categorie_event, other.categorie_event)) {
            return false;
        }
        if (!Objects.equals(this.date_event, other.date_event)) {
            return false;
        }
        if (!Objects.equals(this.Lieu, other.Lieu)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "organisateur=" + organisateur + ", nom_event=" + nom_event + ", categorie_event=" + categorie_event + ", date_event=" + date_event + ", Lieu=" + Lieu + ", image=" + image + '}';
    }
    

    
    
}
