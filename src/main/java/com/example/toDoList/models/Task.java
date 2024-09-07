package com.example.toDoList.models;

import com.example.toDoList.DTO.TaskDTO;
import com.example.toDoList.enums.TaskStatus;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tittle;
    private String description;
    private TaskStatus status;
    @ManyToOne
    private UserEntity userEntity;

    public Task(){};

    public Task(String tittle, String description) {
        this.tittle = tittle;
        this.description = description;
        this.status = TaskStatus.PENDING;
    }

    public Task(TaskDTO taskDTO){
        this.tittle = taskDTO.getTittle();
        this.description = taskDTO.getDescription();
        this.status = taskDTO.getStatus();
    }

    public long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
