package com.veselov.alex.springbootin25steps.controller;

import com.veselov.alex.springbootin25steps.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @Autowired
    private LoginService service;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hi, there!!";
    }

    @GetMapping("/login")
    public String login(ModelMap model) {
        return "login";
    }

    @PostMapping("/login")
    public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (this.service.check(name, password)) {
            model.put("name", name);
            return "welcome";
        } else {
            model.put("error", "Try other creds");
            return "login";
        }
    }
}
