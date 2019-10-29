package entity;

import java.util.Objects;

/**
 *
 * @author SAIFOUN
 */
public class User {
    private int IdEvent;
    private int cin;
    private String nom;
    private String prenom;

    public User(int IdEvent, int cin, String nom, String prenom) {
        this.IdEvent = IdEvent;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setIdEvent(int IdEvent) {
        this.IdEvent = IdEvent;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final User other = (User) obj;
        if (this.IdEvent != other.IdEvent) {
            return false;
        }
        if (this.cin != other.cin) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "IdEvent=" + IdEvent + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    
    
    
    
}