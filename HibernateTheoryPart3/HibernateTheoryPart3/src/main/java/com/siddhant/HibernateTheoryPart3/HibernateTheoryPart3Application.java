package com.siddhant.HibernateTheoryPart3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.object.SqlQuery;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class HibernateTheoryPart3Application {

	public static void main(String[] args) {
		SpringApplication.run(HibernateTheoryPart3Application.class, args);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

		StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
				.configure()               // loads hibernate.cfg.xml
				.applySettings(con.getProperties())
				.build();


		SessionFactory sf= con.buildSessionFactory(reg);
		Session session= sf.openSession();
		session.beginTransaction();

//		Random r=new Random();
//		for(int i=0;i<=50;i++)
//		{
//			Student s= new Student();
//			s.setRollno(10+i);
//			s.setName("Name" + i);
//			s.setMarks(r.nextInt(100));
//			session.persist(s);
//		}

//		Query q=session.createQuery("from Student where marks> 50");
//
//		List<Student> students=q.list();

		/*Query q=session.createQuery("from Student where rollno=19");
		Student student=(Student)q.uniqueResult();
		System.out.println("student");*/

//	  for(Student s: students)
//		{
//			System.out.println(s);
//		}

//		Random r=new Random();
//		for(int i=0;i<=50;i++)
//	{

//			Laptop l= new Laptop();      //Initially it is in new state the after it will come in terminal state
//			l.setLid(72);
//			l.setBrand("Brand72" );
//			l.setPrice(1000);
//     		session.persist(l);
//			 l.setPrice(740);         //persistent state
		//}

//		session.remove(l);        Remove state

//		Laptop lap=session.get(Laptop.class,16);
//		System.out.println(lap);

//		Laptop lap=session.load(Laptop.class,16);
//		System.out.println(lap);



		session.getTransaction().commit();
//		session.detach(l);            //It is in detached state
//		l.setPrice(650);


	}

}
