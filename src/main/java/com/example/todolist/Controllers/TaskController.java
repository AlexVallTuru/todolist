package com.example.todolist.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.todolist.Entities.Task;
import com.example.todolist.Services.TaskService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> newTask(@RequestBody Task task) {
        Task createTask = taskService.createTask(task);
        return new ResponseEntity<>(createTask, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Task>> allTask(){
        List<Task> allTask = taskService.showAll();
        return new ResponseEntity<>(allTask, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable UUID id){
       Optional<Task> task = taskService.findById(id);
       if(task.isPresent()){
        return new ResponseEntity<>(task.get(), HttpStatus.OK);
       } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID id, @RequestBody Task updatedTask){
        Optional<Task> optionalTask = taskService.updateTask(id, updatedTask);
        if(optionalTask.isPresent()){
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id){
        Optional<Task> optionalTask = taskService.findById(id);
        if(optionalTask.isPresent()){
            taskService.deleteTask(optionalTask.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
}
