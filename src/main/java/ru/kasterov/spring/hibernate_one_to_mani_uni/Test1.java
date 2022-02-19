package ru.kasterov.spring.hibernate_one_to_mani_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kasterov.spring.hibernate_one_to_many_bi.entity.Department;
import ru.kasterov.spring.hibernate_one_to_many_bi.entity.Employee;


public class Test1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            Department dep = new Department("IT", 300, 2000);
            Employee emp1 = new Employee("Konstantin", "Kasterov", 1500);
            Employee emp2 = new Employee("Elena", "Orlova", 1000);


            dep.addEmployeeToDep(emp1);
            dep.addEmployeeToDep(emp2);



            session.save(dep);


            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
