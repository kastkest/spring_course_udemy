package ru.kasterov.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("ru.kasterov.spring.aop.aspects.MyPointCuts.allGetMethods()")
    public void beforeGetExceptionGetAdvice(){
        System.out.println("beforeGetExceptionGetAdvice(): обрабатываем исключения при попытке получить книгу/журнал");
    }
}
