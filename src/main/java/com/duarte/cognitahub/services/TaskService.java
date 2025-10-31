/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;


import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.models.Task;
import com.duarte.cognitahub.repositories.CourseRepository;
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
    private final CourseRepository courseRepository;

    public TaskService(TaskRepository taskRepository, CourseRepository courseRepository) {
        this.taskRepository = taskRepository;
        this.courseRepository = courseRepository;
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
    
    
    public List<Task> getTaskByCourse(Long idCourse) {
        Optional<Course> course = courseRepository.findById(idCourse);
        
        return this.taskRepository.findByCourse(course.orElseThrow());
        
    }
    
    
}
