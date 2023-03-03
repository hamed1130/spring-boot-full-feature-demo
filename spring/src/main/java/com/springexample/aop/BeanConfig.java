package com.springexample.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.springexample.aop")
@EnableAspectJAutoProxy
public class BeanConfig {
}
