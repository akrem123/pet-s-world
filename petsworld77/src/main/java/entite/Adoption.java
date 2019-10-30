/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Adoption {
    
    private int id_adoption;
    private String dateann;
    private String nom;
    private String prenom;
    private String type;
    private String description;
    private String imagee ;
    private String Nom_adop;
    private String Prenom_adop;
    private String status;

    public Adoption(int id_adoption, String dateann, String nom, String prenom, String type, String description, String imagee) {
        this.id_adoption = id_adoption;
        this.dateann = dateann;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.imagee = imagee;
    }

    public Adoption() {
    }

    public Adoption(int id_adoption, String dateann, String nom, String prenom, String type, String description, String imagee, String Nom_adop, String Prenom_adop, String status) {
        this.id_adoption = id_adoption;
        this.dateann = dateann;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.imagee = imagee;
        this.Nom_adop = Nom_adop;
        this.Prenom_adop = Prenom_adop;
        this.status = status;
    }

    public Adoption(int id_adoption, String dateann, String nom, String prenom, String type, String description, String imagee, String status) {
        this.id_adoption = id_adoption;
        this.dateann = dateann;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.imagee = imagee;
        this.status = status;
    }
    



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public int getId_adoption() {
        return id_adoption;
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

    public String getImagee() {
        return imagee;
    }

    public void setId_adoption(int id_adoption) {
        this.id_adoption = id_adoption;
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

    public void setImagee(String image) {
        this.imagee = image;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public String getDateann() {
        return dateann;
    }

    public void setDateann(String dateann) {
        this.dateann = dateann;
    }

    public String getNom_adop() {
        return Nom_adop;
    }

    public void setNom_adop(String Nom_adop) {
        this.Nom_adop = Nom_adop;
    }

    public String getPrenom_adop() {
        return Prenom_adop;
    }

    public void setPrenom_adop(String Prenom_adop) {
        this.Prenom_adop = Prenom_adop;
    }

    @Override
    public String toString() {
        return "Adoption{" + "id_adoption=" + id_adoption + ", dateann=" + dateann + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type + ", description=" + description + ", imagee=" + imagee + ", Nom_adop=" + Nom_adop + ", Prenom_adop=" + Prenom_adop + ", status=" + status + '}';
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
        final Adoption other = (Adoption) obj;
        if (this.id_adoption != other.id_adoption) {
            return false;
        }
        if (!Objects.equals(this.dateann, other.dateann)) {
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
        if (!Objects.equals(this.imagee, other.imagee)) {
            return false;
        }
        return true;
    }



   

    public Adoption(String date_adoption, String nom, String prenom, String type, String description, String image) {
        this.dateann = date_adoption;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.imagee = imagee;
    }
    
    
    
    
    
}
