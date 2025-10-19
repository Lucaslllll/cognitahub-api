/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.DTO.UserTask;

import com.duarte.cognitahub.models.Task;

/**
 *
 * @author Lucas
 */
public class TaskDTO {
    private Long id;
    private String name;
    private String details;
    private String created_at;
    private CourseDTO course;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.details = task.getDetails();
        this.created_at = task.getCreated_at().toString();
        this.course = new CourseDTO(task.getCourse());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
    
    
}
