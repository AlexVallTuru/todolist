package com.example.todolist.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.Entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
