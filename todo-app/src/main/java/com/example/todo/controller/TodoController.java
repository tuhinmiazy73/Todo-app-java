package com.example.todo.controller;

import com.example.todo.model.TodoItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TodoController {

    private final List<TodoItem> todoList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoList);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        todoList.add(new TodoItem(description));
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @RequestParam String description) {
        for (TodoItem todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setDescription(description);
                break;
            }
        }
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String toggleComplete(@PathVariable Long id) {
        for (TodoItem todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setCompleted(!todo.isCompleted());
                break;
            }
        }
        return "redirect:/";
    }
}
