package com.aidyninho.greet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/hello")
    public String greet() {
        return "<h1>Hello World!</h1>\n<h2>Finally</h2>";
    }
}
