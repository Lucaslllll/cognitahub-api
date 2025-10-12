/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.services.CourseService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */

@RestController
@RequestMapping("/user")
public class CourseController {
    private final CourseService courseService;
    
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    
    @GetMapping("/courses")
    public List<Course> coursesAll(){
        return courseService.getCourses();
    }
}
