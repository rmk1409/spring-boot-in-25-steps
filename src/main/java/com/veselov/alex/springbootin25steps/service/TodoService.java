package com.veselov.alex.springbootin25steps.service;

import com.veselov.alex.springbootin25steps.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "rmk", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "rmk", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "rmk", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String user, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Todo retrieveTodo(int id) {
        Todo result = null;
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                result = todo;
                break;
            }
        }
        return result;
    }

    public void update(Todo todo) {
        todos.remove(todo);
        todos.add(todo);
    }
}