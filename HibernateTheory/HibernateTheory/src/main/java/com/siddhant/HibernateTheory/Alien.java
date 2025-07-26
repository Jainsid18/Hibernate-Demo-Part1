package com.siddhant.HibernateTheory;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


//@Table(name="alien_table") used for changing / another table
@Entity
public class Alien
{
    @Id
    private int aid;
   // @Transient :- from this we can't put that variable in a table
   // private AlienName aname;
    //@Column(name="alien_colour") for changing the column name
   // private String colour;

    private String aname;
    @OneToMany(mappedBy = "alien",fetch=fetchType.EAGER)  //Fetch is use to make it EAGER (to do work on time/when said )
    private Collection<Laptop> laps=new ArrayList<Laptop>();

    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }

    /*public  AlienName getAlienName() {
        return aname;
    }
    public void setAlienName(AlienName aname) {
        this.aname = aname;
    }*/

    /*public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }*/

    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }

    public Collection<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname +

                '}';
    }


}