package com.veselov.alex.springbootin25steps.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean check(String name, String password){
        return "rmk".equals(name) && "pass".equals(password);
    }
}
