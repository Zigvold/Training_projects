package ru.flamehander.spring.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/unsecured")
    public String unsecuredData(){
        return "unsecured date";
    }

    @GetMapping("/secured")
    public String securedData(){
        return "secured date";
    }

    @GetMapping("/admin")
    public String adminData(){
        return "admin date";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
