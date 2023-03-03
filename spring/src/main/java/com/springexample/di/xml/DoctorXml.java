package com.springexample.di.xml;

import com.springexample.di.Staff;

public class DoctorXml implements Staff {
    private String qualification;

    public DoctorXml(String qualification) { this.qualification = qualification;  }
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    @Override
    public void assist() {
        System.out.println("doctor (di with xml) is assisting...");
    }
}
