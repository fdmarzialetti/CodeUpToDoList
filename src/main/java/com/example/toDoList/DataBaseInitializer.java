package com.example.toDoList;
import com.example.toDoList.models.Task;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.TaskRepositorie;
import com.example.toDoList.repositories.UserEntityRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInitializer implements CommandLineRunner {

    @Autowired
    UserEntityRepositorie userEntityRepositorie;
    @Autowired
    TaskRepositorie taskRepositorie;

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity("fdm_13","123456","fdm_13@hotmail.com");
        userEntityRepositorie.save(user);

        UserEntity user2 = new UserEntity("abqt","654321","abqt@hotmail.com");
        userEntityRepositorie.save(user2);

        Task task = new Task("Task1","TestDataBase");
        user.addTask(task);
        taskRepositorie.save(task);
    }
}
