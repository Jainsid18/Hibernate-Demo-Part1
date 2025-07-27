package com.siddhant.HibernateTheoryPart2;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.lang.*;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HibernateTheoryPart2Application {

	public static void main(String[] args) {
		SpringApplication.run(HibernateTheoryPart2Application.class, args);
		Alien a=null;
		/*a.setAid(103);
		a.setAname("Navin2");
		a.setColour("Green");*/

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
				.configure()               // loads hibernate.cfg.xml
				.applySettings(con.getProperties())
				.build();


		SessionFactory sf= con.buildSessionFactory(reg);
		Session session1= sf.openSession();
		session1.beginTransaction();

		Query q1=session1.createQuery("from Alien where aid=101");
		q1.setCacheable(true);

		a=(Alien)q1.uniqueResult();

	//	a=(Alien) session1.get(Alien.class,101);
		System.out.println(a);

		/*a=(Alien) session1.get(Alien.class,102);     //for checking first level caching in same session
		System.out.println(a);*/

		/*a=(Alien) session1.get(Alien.class,101);    //for checking first level caching in same session
		System.out.println(a);*/


		// session1.persist(a);

		 session1.getTransaction().commit();

		Session session2= sf.openSession();         //for checking Second level caching in different session
		session2.beginTransaction();

		Query q2=session1.createQuery("from Alien where aid=101");
		q2.setCacheable(true);

		a=(Alien)q2.uniqueResult();
		//a=(Alien) session2.get(Alien.class,101);
		System.out.println(a);

		session2.getTransaction().commit();






	}

}
