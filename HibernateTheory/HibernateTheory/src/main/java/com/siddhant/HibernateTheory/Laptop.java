package com.siddhant.HibernateTheory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop
{
    @Id
    private int lid;
    private String brand;
    private int price;
   // @ManyToOne
    //private Student student;
    //@ManyToMany
    //private List<Student> student=new ArrayList<Student>();

    @ManyToOne
    private Alien alien;

    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }

    /*public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }*/

    /*public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }*/

    /*public List<Student> getStudent() {
        return student;
    }
    public void setStudent(List<Student> student) {
        this.student = student;
    }*/

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Alien getAlien() {
        return alien;
    }
    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand=" + brand +
                ", price='" + price + '\'' +
                '}';
    }
}