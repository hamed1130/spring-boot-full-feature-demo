package com.springexample.di.annotation;

import com.springexample.di.Staff;
import org.springframework.stereotype.Component;

@Component
public class NurseAnnotation implements Staff {
    @Override
    public void assist() {
        System.out.println("nurse (di with annotation) is assisting...");
    }
}
