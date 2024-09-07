package com.example.toDoList.controllers;
import com.example.toDoList.DTO.UserEntityDTO;
import com.example.toDoList.DTO.UserEntityPostDTO;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.UserEntityRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserEntityController {
    @Autowired
    UserEntityRepositorie userEntityRepositorie;

    @GetMapping
    public List<UserEntityDTO> getUserEntities(){
        return userEntityRepositorie.findAll().stream().map(ue->new UserEntityDTO(ue)).toList();
    }
    @GetMapping("/{id}")
    public UserEntityDTO getUserEntityById(@PathVariable long id){
        return userEntityRepositorie.findById(id).map(ue->new UserEntityDTO(ue)).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> postUserEntity(@RequestBody UserEntityPostDTO userEntityPostDTO){
        userEntityRepositorie.save(new UserEntity(userEntityPostDTO));
        return ResponseEntity.ok("Se creo el usuario");
    }

}
