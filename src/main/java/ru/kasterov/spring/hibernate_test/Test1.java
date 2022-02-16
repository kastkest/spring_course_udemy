package ru.kasterov.spring.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kasterov.spring.hibernate_test.entity.Employee;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee emp = new Employee("Konstantin", "Kasterov", "IT", 1000);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
