/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;


import com.duarte.cognitahub.models.Task;
import com.duarte.cognitahub.repositories.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public Task getTaskById(Long idTask){
        
        Task task = taskRepository.findById(idTask)
                .orElseThrow(() -> new RuntimeException("Task not found for ID: " + idTask));
        
        
        return task;
        
    }
    
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    
    public Task saveTopic(Task task){
        
        return taskRepository.save(task);
    }
    
    
}
