package com.siddhant.HibernateTheory;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student
{
    @Id
    private int rollno;
    private String name;
    private int marks;
   // @OneToOne
  //  private Laptop laptop;
   // @ManyToMany(mappedBy = "student")
    //private List<Laptop> laptop = new ArrayList<Laptop>();

    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

   /* public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }*/

   /* public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }*/
}