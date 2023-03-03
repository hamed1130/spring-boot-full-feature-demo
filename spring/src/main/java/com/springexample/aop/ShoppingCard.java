package com.springexample.aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCard {
    public void checkout(String status) {
        // we can reduce the cross-cutting concerns, by doing the below common works in here:
        // Logging, Authentication and Authorization, Data Sanitization,...

        System.out.println("checkout() method from ShoppingCard is called, status: " + status);
    }
}
