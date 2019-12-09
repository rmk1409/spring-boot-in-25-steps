package com.veselov.alex.springbootin25steps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hi, there!!";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
