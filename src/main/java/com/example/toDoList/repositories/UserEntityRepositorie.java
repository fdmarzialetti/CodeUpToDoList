package com.example.toDoList.repositories;

import com.example.toDoList.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepositorie extends JpaRepository <UserEntity,Long>{

}
