package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateStudentImagesSortedSetDemo {

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
            Student tempStudent = new Student("Rami", "Malek", "rami@gmail.com");
            Set<String> theImages = tempStudent.getImages();

            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo4.jpg");
            theImages.add("photo5.jpg");

            // start the transaction
            session.beginTransaction();
            System.out.println("saving the student and the images");
            session.persist(tempStudent);

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






















