package com.springbootexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/v1/")
public class HomeController {
    //@RequestMapping(value = "/", method = RequestMethod.GET)

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/")
    public String helloWorld() {
        logger.info("API home called");
        return "API home!";
    }
}
