package com.springexample;

import com.springexample.aop.ShoppingCard;
import com.springexample.di.xml.DoctorXml;
import com.springexample.di.annotation.DoctorAnnotation;
import com.springexample.di.annotation.DoctorCanHaveManyInstances;
import com.springexample.di.annotation.NurseAnnotation;
import com.springexample.di.javaconfiguration.BeanConfig;
import com.springexample.di.lifecycle.DoctorAnnotationLifeCycleTests;
import com.springexample.di.xml.NurseXml;
import com.springexample.di.Staff;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //without di, we need to use the below:
        //Doctor doctor = new Doctor();

        // DI ##############################################################################
        System.out.println("1 ------------");
        di_createDIBeanWithXml();

        // di with annotation
        System.out.println("2 ------------");
        di_createDIBeanWithAnnotation();

        // di with java configuration
        System.out.println("3 ------------");
        di_createDIBeanWithJavaConfig();

        // di with java configuration
        System.out.println("4 ------------");
        di_createDIBeanWithJavaConfigWithScope();

        // di with annotation, testing life cycle of the bean
        System.out.println("5 ------------");
        di_createDIBeanWithAnnotationLifeCycleTesting();
        // di with xml settings

        // AOP ##############################################################################
        System.out.println("6 ------------");
        aop_demoShoppingCard();
    }

    private static void di_createDIBeanWithXml() {
        // loosely decoupling
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // creating context/bean directly with subclass doctor
        DoctorXml doctor = context.getBean(DoctorXml.class);
        doctor.assist();
        System.out.println("doctor qualification: " + doctor.getQualification());

        // creating context/bean directly with subclass nurse
        NurseXml nurse = (NurseXml) context.getBean("nurse");
        nurse.assist();

        // creating context/bean using staff interface and then overrided method in doctor class
        Staff staffDoctor = context.getBean(DoctorXml.class);
        staffDoctor.assist();
        System.out.println("doctor qualification: " + ((DoctorXml) staffDoctor).getQualification());

        // creating context/bean using staff interface and then overrided method in nurse class
        Staff staffNurse = context.getBean(NurseXml.class);
        staffNurse.assist();
    }
    private static void di_createDIBeanWithAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Staff staffDoctor = context.getBean(DoctorAnnotation.class);
        staffDoctor.assist();

        Staff staffNurse = context.getBean(NurseAnnotation.class);
        staffNurse.assist();
    }
    private static void di_createDIBeanWithJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("using java config -> ");
        DoctorAnnotation doctor = context.getBean(DoctorAnnotation.class);
        doctor.assist();
    }
    private static void di_createDIBeanWithJavaConfigWithScope() {
        System.out.println("using java config with scope request (not singleton) -> ");
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        DoctorCanHaveManyInstances doctor = context.getBean(DoctorCanHaveManyInstances.class);
        doctor.assist();
        doctor.setQualification("MBHS");
        System.out.println(doctor);

        DoctorCanHaveManyInstances doctor1 = context.getBean(DoctorCanHaveManyInstances.class);
        doctor1.assist();
        //doctor1.setQualification("MBHS");
        System.out.println(doctor1);

        System.out.println(doctor == doctor1);
    }
    private static void di_createDIBeanWithAnnotationLifeCycleTesting() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Staff staffDoctor = context.getBean(DoctorAnnotationLifeCycleTests.class);
        staffDoctor.assist();

        //Staff staffNurse = context.getBean(NurseAnnotation.class);
        //staffNurse.assist();
    }
    private static void aop_demoShoppingCard() {
        ApplicationContext context = new AnnotationConfigApplicationContext(com.springexample.aop.BeanConfig.class);

        ShoppingCard card = context.getBean(ShoppingCard.class);
        card.checkout("Cancelled");
    }

}