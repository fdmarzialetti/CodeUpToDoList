package com.example.toDoList.handlers;

public class TaskNotFound extends  RuntimeException{
    public TaskNotFound(String message) {
        super(message);
    }
}
