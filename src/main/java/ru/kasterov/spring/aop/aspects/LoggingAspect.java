package ru.kasterov.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void  get*())")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice(): попытка получить книгу");
    }

    @Before("execution(* returnBook())")
    public void beforeReturnBook() {
        System.out.println("beforeGetBookAdvice(): попытка вернуть книгу");
    }
}
