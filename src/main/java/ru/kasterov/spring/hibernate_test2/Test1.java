package ru.kasterov.spring.hibernate_test2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kasterov.spring.hibernate_test.entity.Employee;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee emp = new Employee("Alex", "Ivanov", "IT", 900);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            System.out.println("Done");
            System.out.println(emp);
        } finally {
            sessionFactory.close();
        }
    }
}
