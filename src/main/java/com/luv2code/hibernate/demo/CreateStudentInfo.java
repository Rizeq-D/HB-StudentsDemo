package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Status;
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
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create the object
            Student tempStudent1 = new Student("Rami", "Malek", "rami@gmail.com", Status.ACTIVE);
            Student tempStudent2 = new Student("Tom", "Hanks", "tom@gmail.com", Status.INACTIVE);

            // start the transaction
            session.beginTransaction();
            System.out.println("saving the students...");
            session.persist(tempStudent1);
            session.persist(tempStudent2);

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






















