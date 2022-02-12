package ru.kasterov.spring.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();
    public void addStudents() {
        Student student1 = new Student("Konstantin Kasterov", 4, 4.3);
        Student student2 = new Student("Ivan Petrov", 2, 4.5);
        Student student3 = new Student("Elena Ivanova", 1, 4.8);

        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents() {
        System.out.println("Information from method getStudents()");
        System.out.println(students);
        return students;
    }
}
