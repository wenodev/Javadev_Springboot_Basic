package com.tutorial.javadev.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/greeting")
    public String hello(){
        return "HelloWorld!";
    }

}
