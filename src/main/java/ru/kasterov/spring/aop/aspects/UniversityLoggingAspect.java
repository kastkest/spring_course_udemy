package ru.kasterov.spring.aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice(): логируем получение списка студентов перед методом getStudents()");
    }

    @AfterReturning("execution(* getStudents())")
    public void afterReturningGetStudentsLoggingAdvice() {
        System.out.println("afterReturningGetStudentsLoggingAdvice(): логируем получение списка студентов после работы метода getStudents()");
    }
}
