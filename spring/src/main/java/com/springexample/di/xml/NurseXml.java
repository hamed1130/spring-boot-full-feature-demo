package com.springexample.di.xml;

import com.springexample.di.Staff;

public class NurseXml implements Staff {
    public void assist() {
        System.out.println("nurse (di with xml) is assisting...");
    }
}
