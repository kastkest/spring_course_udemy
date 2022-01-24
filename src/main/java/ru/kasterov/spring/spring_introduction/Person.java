package ru.kasterov.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public void setSurname(String surname) {
        System.out.println("Class person: set surname");
        this.surname = surname;
    }

    public void setAge(int age) {
        System.out.println("Class person: set age");
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Autowired
    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }


//    public Person() {
//        System.out.println("Person bean is created");
//    }
    // pet -> setPet
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely pet!");
        pet.say();
    }
}
