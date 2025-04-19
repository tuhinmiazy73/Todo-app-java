package com.example.todo.model;

public class TodoItem {
    private static long count = 0;
    private Long id;
    private String description;
    private boolean completed;

    public TodoItem(String description) {
        this.id = ++count;
        this.description = description;
        this.completed = false;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }

    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
