package com.springexample.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // execution((return type) (any package).(any class).(any method(..)) )
    @Before("execution(* com.springexample.aop.ShoppingCard.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        System.out.println("logging something BEFORE...");
        System.out.println("    getting the method signature: " + jp.getSignature());
        System.out.println("    getting method param: " + jp.getArgs()[0]);
    }

    // execution((return type) (any package).(any class).(any method(..)) )
    @After("execution(* com.springexample.aop.*.checkout(..))")
    public void afterLogger() {
        System.out.println("logging something AFTER...");
    }
}
