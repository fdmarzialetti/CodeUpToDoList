package com.example.toDoList.DTO;

import com.example.toDoList.enums.TaskStatus;
import com.example.toDoList.models.Task;
import com.example.toDoList.models.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class TaskDTO {
    private long id;
    private String tittle;
    private String description;
    private TaskStatus status;

    public TaskDTO(Task task){
        this.id = task.getId();
        this.tittle = task.getTittle();
        this.description = task.getDescription();
        this.status = task.getStatus();
    }

    public long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
