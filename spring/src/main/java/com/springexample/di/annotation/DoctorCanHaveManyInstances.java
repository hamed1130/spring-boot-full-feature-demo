package com.springexample.di.annotation;

import com.springexample.di.Staff;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")  // default is 'singleton'
public class DoctorCanHaveManyInstances implements Staff {
    private String qualification;

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    @Override
    public void assist() {
        System.out.println("doctor is assisting... creates a new object everytime called");
    }

    @Override
    public String toString() {
        return "DoctorCanHaveManyInstances{" + "qualification='" + qualification + '}';
    }
}
