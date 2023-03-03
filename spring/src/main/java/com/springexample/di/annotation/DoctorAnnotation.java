package com.springexample.di.annotation;

import com.springexample.di.Staff;
import org.springframework.stereotype.Component;

@Component
public class DoctorAnnotation implements Staff {
    @Override
    public void assist() {
        System.out.println("doctor (di with annotation) is assisting...");
    }
}
