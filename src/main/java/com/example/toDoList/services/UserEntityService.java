package com.example.toDoList.services;

import com.example.toDoList.DTO.UserEntityDTO;
import com.example.toDoList.DTO.UserEntityPostDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserEntityService {

    public List<UserEntityDTO> getUserEntities();

    public UserEntityDTO getUserEntityById(long id);

    public ResponseEntity<String> postUserEntity(UserEntityPostDTO userEntityPostDTO);

    public ResponseEntity<String> deleteUserEntity(long id);
}
