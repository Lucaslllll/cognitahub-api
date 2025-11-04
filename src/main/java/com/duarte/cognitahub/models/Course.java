/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    
    @Column(unique=true, nullable=false)
    private String name;
    
    private String thumb;
    
    public Course(){}
    
    public Course(String name){
        this.name = name;
    }
    
    public Course(String name, String thumb){
        this.name = name;
        this.thumb = thumb;
        
    }
    
    public Long getId(){
        return idCourse;
    }
    
    
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    
    public String getName(){
        return name;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
}
