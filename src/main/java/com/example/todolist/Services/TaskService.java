package com.example.todolist.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.Entities.Task;
import com.example.todolist.Repositories.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> showAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(UUID id) {
        return taskRepository.findById(id);
                
    }

    public Optional<Task> updateTask(UUID id, Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(taskDetails.getDescription());
            task.setState(taskDetails.getState());
            task.setDateCreacion(taskDetails.getDateCreacion());
            task.setDateLimit(taskDetails.getDateLimit());
            return Optional.of(taskRepository.save(task));
        } else {
            return Optional.empty();
        }
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
