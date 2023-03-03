package com.springexample.di.lifecycle;

import com.springexample.di.Staff;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DoctorAnnotationLifeCycleTests implements Staff, BeanNameAware, InitializingBean, DisposableBean {
    @Override
    public void assist() {
        System.out.println("doctor (di with annotation, testing life cycle) is assisting...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName() is called: " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() is called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() is called");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Custom postConstruct() is called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Custom preDestroy() is called");
    }
}
