/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;
    
    @Column(unique=true, nullable=false)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String details;
    
    private String downloadFile;
    
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate created_at;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "Course_idCourse", referencedColumnName = "idCourse")
    private Course course;
    
    
    public Task(){}
    
    public Task(String name, String details, LocalDate created_at, Course course, String downloadFile){
        this.name = name;
        this.details = details;
        this.created_at = created_at;
        this.course = course;
        this.downloadFile = downloadFile;
    }

    public Long getId(){
        return this.idTask;
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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDownloadFile() {
        return downloadFile;
    }

    public void setDownloadFile(String downloadFile) {
        this.downloadFile = downloadFile;
    }
    
}
