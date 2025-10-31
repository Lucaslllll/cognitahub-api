/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.DTO;

import com.duarte.cognitahub.models.Course;

/**
 *
 * @author Lucas
 */
public class CourseAllDTO {
    private Long id;
    private String name;
    private String thumb;

    public CourseAllDTO(Long id, String name, String thumb) {
        this.id = id;
        this.name = name;
        this.thumb = thumb;
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    
    
}
