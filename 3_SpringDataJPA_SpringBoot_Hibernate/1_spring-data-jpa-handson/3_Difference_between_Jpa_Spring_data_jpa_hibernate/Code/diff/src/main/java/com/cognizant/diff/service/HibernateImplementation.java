package com.cognizant.diff.service;

import com.cognizant.diff.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class HibernateImplementation {
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Transaction transaction = null;
    Session session = null;
    String empid = null;
    public void HibernateImplementationsave(Employee employee) {
        try {
            config = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            System.out.println("\n Adding Employee using Hibernate: " + employee.toString());
            empid = (String)session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}
