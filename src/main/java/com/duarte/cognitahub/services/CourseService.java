/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.repositories.CourseRepository;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author Lucas
 */
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
}
