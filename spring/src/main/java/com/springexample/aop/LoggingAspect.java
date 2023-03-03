package com.springexample.aop;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    public void logger() {
        System.out.println("logging");
    }
}
