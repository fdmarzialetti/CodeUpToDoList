package com.example.toDoList.controllers;

import com.example.toDoList.DTO.TaskDTO;
import com.example.toDoList.DTO.TaskPostDTO;
import com.example.toDoList.DTO.UserEntityDTO;
import com.example.toDoList.DTO.UserEntityPostDTO;
import com.example.toDoList.models.Task;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.TaskRepositorie;
import com.example.toDoList.repositories.UserEntityRepositorie;
import com.example.toDoList.services.TaskService;
import com.example.toDoList.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<TaskDTO> getUserEntities(){
        return taskService.getUserEntities();
    }
    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable long id){
        return taskService.getTaskById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addTaskToUser(@RequestBody TaskPostDTO taskPostDTO, @PathVariable long id){
        return taskService.addTaskToUser(taskPostDTO,id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id){
        return taskService.deleteTask(id);
    }
}
