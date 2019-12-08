package com.veselov.alex.springbootin25steps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/login")
    @ResponseBody
    public String hello(){
        return "Hi, there!";
    }
}
