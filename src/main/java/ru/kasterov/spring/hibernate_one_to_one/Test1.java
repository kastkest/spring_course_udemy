package ru.kasterov.spring.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kasterov.spring.hibernate_one_to_one.entity.Detail;
import ru.kasterov.spring.hibernate_one_to_one.entity.Employee;


public class Test1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {



            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);
            System.out.println(emp.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
