package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class CreateStudentInfo {

    public static void main( String[] args ) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create the object
            Student tempStudent = new Student("Rami", "Malek", "rami@gmail.com");
            Address billingAddress = new Address("Ally", "Stadt", "00000");

            // start the transaction
            session.beginTransaction();
            System.out.println("saving the student's address");
            tempStudent.setBillingAddress(billingAddress);
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






















