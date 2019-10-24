/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Demande {
   
    private int numero;
    private String dateann;
    private String nom;
    private String prenom;
    private String type;
    private String description;
    private String imagee ;

    public Demande(int numero, String dateann, String nom, String prenom, String type, String description) {
        this.numero = numero;
        this.dateann = dateann;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
    }

    public Demande() {
    }
    

    public int getNumero() {
        return numero;
    }

    public String getDateann() {
        return dateann;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDateann(String dateann) {
        this.dateann = dateann;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final Demande other = (Demande) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.dateann, other.dateann)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Demande{" + "numero=" + numero + ", dateann=" + dateann + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type + ", description=" + description + '}';
    }

    public Demande(String dateann, String nom, String prenom, String type, String description) {
        this.dateann = dateann;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
    }

    public Demande(int numero, String dateann, String nom, String prenom, String type, String description, String imagee) {
        this.numero = numero;
        this.dateann = dateann;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.imagee = imagee;
    }

    public String getImagee() {
        return imagee;
    }

    public void setImagee(String imagee) {
        this.imagee = imagee;
    }

   
}