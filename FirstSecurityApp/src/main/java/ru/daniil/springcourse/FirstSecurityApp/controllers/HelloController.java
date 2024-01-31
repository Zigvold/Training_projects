package ru.daniil.springcourse.FirstSecurityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("first")
public class HelloController {

    @GetMapping()
    public String hello(){
        return "first/hello";
    }
}
