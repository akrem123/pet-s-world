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
public class User {
    protected int id;
    protected String nom;
    protected String email;
    protected String mdp;
    protected String type;
    
    
    public User(){
    }
    
    public User(String nom, String email, String mdp, String type) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.type = type;
    }
    
    
    
    public User(int id, String nom, String email, String mdp, String type) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.type = type;
    }
    
    public User(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }
    
    
    
    public User(String nom, String email, String mdp) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }
    
    public User(int id, String email, String mdp) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", type=" + type + '}';
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
