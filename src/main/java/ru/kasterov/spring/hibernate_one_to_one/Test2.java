package ru.kasterov.spring.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kasterov.spring.hibernate_one_to_one.entity.Detail;
import ru.kasterov.spring.hibernate_one_to_one.entity.Employee;


public class Test2 {

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
            Employee emp1 = new Employee("Kolya", "Ivanov", "HR", 900);
            Detail detail1 = new Detail("NY", "886544","sfhf@sjdfsf.ru");

            Detail detail = session.get(Detail.class, 2);
            System.out.println(detail.getEmployee());

//            emp1.setEmpDetail(detail1);
//            detail1.setEmployee(emp1);


//            session.save(detail1);

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
