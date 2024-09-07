package com.example.toDoList;

import com.example.toDoList.models.Task;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.TaskRepositorie;
import com.example.toDoList.repositories.UserEntityRepositorie;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInitializer implements CommandLineRunner {

    @Autowired
    UserEntityRepositorie userEntityRepositorie;
    @Autowired
    TaskRepositorie taskRepositorie;

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity("fdm","123456","fdm_13@hotmail.com");
        userEntityRepositorie.save(user);
        Task task = new Task("Task1","TestDataBase");
        user.addTask(task);
        taskRepositorie.save(task);
    }
}
