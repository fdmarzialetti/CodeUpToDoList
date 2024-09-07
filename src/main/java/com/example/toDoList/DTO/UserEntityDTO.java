package com.example.toDoList.DTO;

import com.example.toDoList.models.Task;
import com.example.toDoList.models.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserEntityDTO {

    private long id;
    private String username;
    private String password;
    private String email;
    private Set<TaskDTO> tasks = new HashSet<>();

    public UserEntityDTO(UserEntity userEntity){
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.tasks= userEntity.getTasks().stream().map(t->new TaskDTO(t)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<TaskDTO> getTasks() {
        return tasks;
    }
}
