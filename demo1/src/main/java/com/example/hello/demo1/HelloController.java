package com.example.hello.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s! Spring Boot is running.", name);
    }   
    @GetMapping("/goodbye")
    public String sayGoodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Goodbye, %s! Spring Boot is running.", name);
    }
}