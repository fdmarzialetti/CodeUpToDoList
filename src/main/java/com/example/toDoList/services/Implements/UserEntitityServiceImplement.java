package com.example.toDoList.services.Implements;

import com.example.toDoList.DTO.UserEntityDTO;
import com.example.toDoList.DTO.UserEntityPostDTO;
import com.example.toDoList.handlers.UserEntityNotFound;
import com.example.toDoList.models.UserEntity;
import com.example.toDoList.repositories.UserEntityRepositorie;
import com.example.toDoList.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserEntitityServiceImplement implements UserEntityService {
    @Autowired
    UserEntityRepositorie userEntityRepositorie;

    @Override
    public List<UserEntityDTO> getUserEntities() {
        return userEntityRepositorie.findAll().stream().map(ue->new UserEntityDTO(ue)).toList();
    }

    @Override
    public UserEntityDTO getUserEntityById(long id) {
        return userEntityRepositorie.findById(id).map(ue->new UserEntityDTO(ue)).orElseThrow(()->new UserEntityNotFound("The user with id "+id+" does not exist."));

    }

    @Override
    public ResponseEntity<String> postUserEntity(UserEntityPostDTO userEntityPostDTO) {
        userEntityRepositorie.save(new UserEntity(userEntityPostDTO));
        return ResponseEntity.ok("The user was successfully created.");
    }

    @Override
    public ResponseEntity<String> deleteUserEntity(long id) {
        if(!userEntityRepositorie.existsById(id)){
            return (ResponseEntity<String>) ResponseEntity.notFound();
        }
        userEntityRepositorie.deleteById(id);
        return ResponseEntity.ok("The user with id "+id+" has been deleted, along with all associated tasks.");
    }
}
