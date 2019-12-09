package com.veselov.alex.springbootin25steps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hi, there!!";
    }

    @GetMapping("/login")
    public String login(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        return "login";
    }
}
