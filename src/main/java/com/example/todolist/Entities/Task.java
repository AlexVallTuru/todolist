package com.example.todolist.Entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String state;
    private Date dateCreacion;
    private Date dateLimit;

    public Task(String title, String description, String state, Date dateLimit) {
        this.title = title;
        this.description = description;
        this.state = state;
        this.dateCreacion = new Date();
        this.dateLimit = dateLimit;
    }

    public Task() {
    }
}
