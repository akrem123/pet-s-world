/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author SAIFOUN
 */
public class Participation {
    private int id;
    private int userid;
    private int eventsid;

    public Participation(int id, int userid, int eventsid) {
        this.id = id;
        this.userid = userid;
        this.eventsid = eventsid;
    }

    public Participation(int userid, int eventsid) {
        this.userid = userid;
        this.eventsid = eventsid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getEventsid() {
        return eventsid;
    }

    public void setEventsid(int eventsid) {
        this.eventsid = eventsid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Participation other = (Participation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        if (this.eventsid != other.eventsid) {
            return false;
        }
        return true;
    }
    
    
    
    
}
