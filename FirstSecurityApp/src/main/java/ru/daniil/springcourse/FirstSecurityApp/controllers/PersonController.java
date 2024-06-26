package ru.daniil.springcourse.FirstSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.daniil.springcourse.FirstSecurityApp.security.PersonDetails;

@Controller
@RequestMapping("people")
public class PersonController {

    @GetMapping()
    public String index(){
        return "people/index";
    }

    @GetMapping()
    public String  showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "people/show";
    }

}
