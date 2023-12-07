package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentInfo {

    public static void main( String[] args ) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create the object
            Student tempUser = new Student("Rami", "Malek", "rami@gmail.com", "Hibernate");
            Instructor tempIns = new Instructor("Tom", "Hanks", "tom@gmail.com", 40000.00);

            // start the transaction
            session.beginTransaction();
            System.out.println("saving the Info...");
            session.persist(tempUser);
            session.persist(tempIns);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");

        }

        // clean up the code
        finally {
            session.close();
            factory.close();

        }
    }
}






















