package com.example.toDoList.services.Implements;

import com.example.toDoList.DTO.TaskDTO;
import com.example.toDoList.DTO.TaskPostDTO;
import com.example.toDoList.handlers.TaskNotFound;
import com.example.toDoList.handlers.UserEntityNotFound;
import com.example.toDoList.models.Task;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.TaskRepositorie;
import com.example.toDoList.repositories.UserEntityRepositorie;
import com.example.toDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class TaskServiceImplement implements TaskService {
    @Autowired
    TaskRepositorie taskRepositorie;
    @Autowired
    UserEntityRepositorie userEntityRepositorie;


    public List<TaskDTO> getUserEntities(){
        return taskRepositorie.findAll().stream().map(t->new TaskDTO(t)).toList();
    }

    public TaskDTO getTaskById(long id){
        return taskRepositorie.findById(id).map(t->new TaskDTO(t)).orElseThrow(()->new TaskNotFound("The task with "+id+" does not exist."));
    }

    public ResponseEntity<String> addTaskToUser(TaskPostDTO taskPostDTO,long id){
        UserEntity user = userEntityRepositorie.findById(id).orElseThrow(()->new UserEntityNotFound("The user with "+id+" does not exist."));
        Task task = new Task(taskPostDTO);
        user.addTask(task);
        taskRepositorie.save(task);
        userEntityRepositorie.save(user);
        return ResponseEntity.ok("The new task of the user with id "+id+" was added successfully.");
    }

    public ResponseEntity<String> deleteTask(long id){
        if(!taskRepositorie.existsById(id)){
            return (ResponseEntity<String>) ResponseEntity.notFound();
        }
        taskRepositorie.deleteById(id);
        return ResponseEntity.ok("The task with id "+id+" has been deleted.");
    }
}
