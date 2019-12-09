package com.veselov.alex.springbootin25steps.controller;

import com.veselov.alex.springbootin25steps.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name"})
public class Todo {

    @Autowired
    private TodoService service;

    @GetMapping("/list-todos")
    public String login(ModelMap model) {
        model.put("todos", this.service.retrieveTodos((String) model.getAttribute("name")));
        return "list-todos";
    }
}
