package com.springexample.di.javaconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springexample.di.annotation")
public class BeanConfig {
}
