package ru.flamehander.spring.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/unsecured")
    public String unsecuredData(){
        return "unsecured data";
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/secured")
    public String securedData(){
        return "secured data";
    }

    @GetMapping("/admin")
    public String adminData(){
        return "admin data";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
