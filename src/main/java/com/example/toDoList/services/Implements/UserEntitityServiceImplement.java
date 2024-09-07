package com.example.toDoList.services.Implement;

import com.example.toDoList.DTO.UserEntityDTO;
import com.example.toDoList.DTO.UserEntityPostDTO;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.UserEntityRepositorie;
import com.example.toDoList.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserEntitityServiceImplement implements UserEntityService {
    @Autowired
    UserEntityRepositorie userEntityRepositorie;

    @Override
    public List<UserEntityDTO> getUserEntities() {
        return userEntityRepositorie.findAll().stream().map(ue->new UserEntityDTO(ue)).toList();
    }

    @Override
    public UserEntityDTO getUserEntityById(long id) {
        return userEntityRepositorie.findById(id).map(ue->new UserEntityDTO(ue)).orElseThrow(()->new RuntimeException("No existe el usuario: "+id));

    }

    @Override
    public ResponseEntity<String> postUserEntity(UserEntityPostDTO userEntityPostDTO) {
        userEntityRepositorie.save(new UserEntity(userEntityPostDTO));
        return ResponseEntity.ok("Se creo el usuario");
    }

    @Override
    public void deleteUserEntity(long id) {
        userEntityRepositorie.deleteById(id);
    }
}
