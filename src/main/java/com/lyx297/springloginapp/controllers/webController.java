package com.lyx297.springloginapp.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webController {
    @GetMapping("/home")
    public String allAccess() {
        return "home";
    }
}
