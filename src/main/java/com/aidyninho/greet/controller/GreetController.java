package com.aidyninho.greet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping
    public String greet() {
        return "Hello World!";
    }
}
