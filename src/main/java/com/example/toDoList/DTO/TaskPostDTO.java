package com.example.toDoList.DTO;

import com.example.toDoList.enums.TaskStatus;
import com.example.toDoList.models.Task;

public class TaskPostDTO {
    private String tittle;
    private String description;

    public TaskPostDTO(){

    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

}
