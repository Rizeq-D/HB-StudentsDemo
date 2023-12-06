package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentImagesDemo {

    public static void main(String args[]) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the student id
            int theId = 1;
            Student student = session.get(Student.class, theId);

            // print the student information
            System.out.println("Student's details: " + student);

            // print associated images
            System.out.println("the images" + student.getImages());

            // commit the transaction
            session.getTransaction().commit();

            //done
            System.out.println("Done");
        } finally {

            session.close();
            factory.close();
        }
    }

}
