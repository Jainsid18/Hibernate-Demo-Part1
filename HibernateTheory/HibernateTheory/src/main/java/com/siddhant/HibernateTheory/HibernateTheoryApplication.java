package com.siddhant.HibernateTheory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.lang.*;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.lang.reflect.Method;
import java.util.Collection;


@SpringBootApplication
public class HibernateTheoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateTheoryApplication.class, args);

		//For Embedded object
	/*	AlienName an=new AlienName();
		an.setFname("ram");
		an.setMname("ratan");
		an.setLname("joshi")*/

		Alien a1= new Alien();
		a1.setAid(103);
		//a1.setColour("Purple");
		//a1.setAlienName(an);
		a1.setAname("Dev");


		Laptop laptop=new Laptop();
		laptop.setLid(105);
		laptop.setPrice(10000);
		laptop.setBrand("DELL");
		laptop.setAlien(a1);
		//laptop.setLname("Lenovo");



		/*Student s=new Student();
		s.setName("Sambhav");
		s.setRollno(3);
		s.setMarks(50);
		s.getLaptop().add(laptop);
		//s.setLaptop(laptop);

		laptop.getStudent().add(s);*/
		Configuration con= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

		StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
				.configure()               // loads hibernate.cfg.xml
				.applySettings(con.getProperties())
				.build();


		SessionFactory sf= con.buildSessionFactory(reg);
		Session session= sf.openSession();
		Transaction tx = session.beginTransaction();
		//a1 = (Alien)  session.find(Alien.class,101);


		//For EAGER AND LAZY
		Alien a12=session.get(Alien.class,105);

		System.out.println(a12.getAname());
		Collection<Laptop> laps=a1.getLaps();

		for(Laptop l: laps)
		{
			System.out.println(l);
		}

		//session.persist(laptop);// or save
		//session.persist(s);// or save

		tx.commit();
		session.close();
		sf.close();




	}

}