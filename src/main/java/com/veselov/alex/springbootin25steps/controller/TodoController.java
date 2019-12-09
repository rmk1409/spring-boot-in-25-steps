package com.veselov.alex.springbootin25steps.controller;

import com.veselov.alex.springbootin25steps.model.Todo;
import com.veselov.alex.springbootin25steps.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes({"name"})
public class TodoController {

    @Autowired
    private TodoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

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
    public String deleteTodo(@RequestParam int id) {
        this.service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = this.service.retrieveTodo(id);
        model.put("todo", todo);
        return "todo-form";
    }

    @PostMapping("/update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()){
            return "todo-form";
        }
        todo.setUser((String) model.getAttribute("name"));
        this.service.update(todo);
        return "redirect:/list-todos";
    }

    @PostMapping("/add-todo")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()){
            return "todo-form";
        }
        this.service.addTodo((String) model.getAttribute("name"), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }
}
