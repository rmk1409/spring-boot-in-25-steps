package com.veselov.alex.springbootin25steps.controller;

import com.veselov.alex.springbootin25steps.model.Todo;
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
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/list-todos")
    public String shouwTodoList(ModelMap model) {
        model.put("todos", this.service.retrieveTodos((String) model.getAttribute("name")));
        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String showTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0, (String) model.getAttribute("name"), "some-desc", new Date(), false));
        return "todo-form";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id, ModelMap model) {
        this.service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @PostMapping("/add-todo")
    public String addTodo(ModelMap model, Todo todo) {
        this.service.addTodo((String) model.getAttribute("name"), todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }
}
