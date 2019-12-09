package com.veselov.alex.springbootin25steps.controller;

import com.veselov.alex.springbootin25steps.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes({"name"})
public class Todo {

    @Autowired
    private TodoService service;

    @GetMapping("/list-todos")
    public String shouwTodoList(ModelMap model) {
        model.put("todos", this.service.retrieveTodos((String) model.getAttribute("name")));
        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String showTodoPage(ModelMap model) {
        return "todo-form";
    }

    @PostMapping("/add-todo")
    public String addTodo(ModelMap model, @RequestParam String desc) {
        this.service.addTodo((String) model.getAttribute("name"), desc, new Date(), false);
        return "redirect:/list-todos";
    }
}
