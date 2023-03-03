package com.springexample.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(com.springexample.aop..*)")
    public void authenticationPointcut() {

    }

    @Pointcut("within(com.springexample.aop..*)")
    public void authorizationPointcut() {

    }

    @Before("authenticationPointcut() && authorizationPointcut()")
    public void authenticate() {
        System.out.println("Authenticating the request...");
    }
}
