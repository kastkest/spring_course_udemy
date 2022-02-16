package ru.kasterov.spring.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kasterov.spring.hibernate_test.entity.Employee;

import java.util.List;

public class Test4 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);
            session.createQuery("update Employee set salary = 1500 where name = 'Alex'").executeUpdate();


            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
