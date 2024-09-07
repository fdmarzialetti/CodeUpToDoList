package com.example.toDoList.controllers;
import com.example.toDoList.DTO.UserEntityDTO;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.UserEntityRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class UserEntityController {
    @Autowired
    UserEntityRepositorie userEntityRepositorie;

    @GetMapping
    public List<UserEntityDTO> getUserEntities(){
        return userEntityRepositorie.findAll().stream().map(ue->new UserEntityDTO(ue)).toList();
    }
}
