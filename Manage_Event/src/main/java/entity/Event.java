/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author SAIFOUN
 */
public class Event {
   
    
    private int IdEvent;
    private String NomEvent;
    private String CategorieEvent;
    private int NbrPlaceDispo;
    private String DateEvent;
    private int HeureDebEvent;
    private String Etat;
    private String organisateur;
    private String image_ev;

    public Event(int IdEvent, String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent, int HeureDebEvent, String Etat, String organisateur, String image_ev) {
        this.IdEvent = IdEvent;
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
        this.Etat = Etat;
        this.organisateur = organisateur;
        this.image_ev = image_ev;
    }

    public Event(String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent, int HeureDebEvent) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
    }

    public Event() {
    }

    public Event(String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent, int HeureDebEvent, String image_ev) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
        this.image_ev = image_ev;
    }

    public Event(String NomEvent) {
        this.NomEvent = NomEvent;
    }

    public Event(String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent, int HeureDebEvent, String Etat, String organisateur, String image_ev) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
        this.Etat = Etat;
        this.organisateur = organisateur;
        this.image_ev = image_ev;
    }

    public Event(String NomEvent, String CategorieEvent, String DateEvent, int HeureDebEvent) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
    }

    public Event(int IdEvent, String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent, int HeureDebEvent) {
        this.IdEvent = IdEvent;
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public String getNomEvent() {
        return NomEvent;
    }

    public String getCategorieEvent() {
        return CategorieEvent;
    }

    public int getNbrPlaceDispo() {
        return NbrPlaceDispo;
    }

    public String getDateEvent() {
        return DateEvent;
    }

    public int getHeureDebEvent() {
        return HeureDebEvent;
    }

    public String getEtat() {
        return Etat;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public String getImage_ev() {
        return image_ev;
    }

    public void setIdEvent(int IdEvent) {
        this.IdEvent = IdEvent;
    }

    public void setNomEvent(String NomEvent) {
        this.NomEvent = NomEvent;
    }

    public void setCategorieEvent(String CategorieEvent) {
        this.CategorieEvent = CategorieEvent;
    }

    public void setNbrPlaceDispo(int NbrPlaceDispo) {
        this.NbrPlaceDispo = NbrPlaceDispo;
    }

    public void setDateEvent(String DateEvent) {
        this.DateEvent = DateEvent;
    }

    public void setHeureDebEvent(int HeureDebEvent) {
        this.HeureDebEvent = HeureDebEvent;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public void setImage_ev(String image_ev) {
        this.image_ev = image_ev;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public Event(int IdEvent, String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent, int HeureDebEvent, String Etat, String organisateur) {
        this.IdEvent = IdEvent;
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
        this.Etat = Etat;
        this.organisateur = organisateur;
    }

    public Event(String NomEvent, String CategorieEvent, int NbrPlaceDispo, String DateEvent) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
    }

    public Event(String NomEvent, String CategorieEvent, int NbrPlaceDispo) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
    }

    public Event(String NomEvent, String CategorieEvent) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
    }

    public Event(int IdEvent, String NomEvent, String CategorieEvent, String DateEvent, int HeureDebEvent) {
        this.IdEvent = IdEvent;
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.DateEvent = DateEvent;
        this.HeureDebEvent = HeureDebEvent;
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
        if (this.IdEvent != other.IdEvent) {
            return false;
        }
        if (this.NbrPlaceDispo != other.NbrPlaceDispo) {
            return false;
        }
        if (this.HeureDebEvent != other.HeureDebEvent) {
            return false;
        }
        if (!Objects.equals(this.NomEvent, other.NomEvent)) {
            return false;
        }
        if (!Objects.equals(this.CategorieEvent, other.CategorieEvent)) {
            return false;
        }
        if (!Objects.equals(this.DateEvent, other.DateEvent)) {
            return false;
        }
        if (!Objects.equals(this.Etat, other.Etat)) {
            return false;
        }
        if (!Objects.equals(this.organisateur, other.organisateur)) {
            return false;
        }
        if (!Objects.equals(this.image_ev, other.image_ev)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "IdEvent=" + IdEvent + ", NomEvent=" + NomEvent + ", CategorieEvent=" + CategorieEvent + ", NbrPlaceDispo=" + NbrPlaceDispo + ", DateEvent=" + DateEvent + ", HeureDebEvent=" + HeureDebEvent + ", Etat=" + Etat + ", organisateur=" + organisateur + ", image_ev=" + image_ev + '}';
    }

    public Event(int IdEvent) {
        this.IdEvent = IdEvent;
    }
    

   
    
}