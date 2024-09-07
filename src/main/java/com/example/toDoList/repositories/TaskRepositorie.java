package com.example.toDoList.repositories;
import com.example.toDoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositorie extends JpaRepository<Task,Long> {
}
