package com.example.toDoList.handlers;

public class UserEntityNotFound extends RuntimeException{
    public UserEntityNotFound(String message) {
        super(message);
    }
}
