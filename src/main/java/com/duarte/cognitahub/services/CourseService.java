/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.DTO.CourseAllDTO;
import com.duarte.cognitahub.exceptions.ResourceNotFoundException;
import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.repositories.CourseRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
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
    
    public List<CourseAllDTO> getCoursesDTO(){
        return courseRepository.findAll(Sort.by(Sort.Direction.ASC, "idCourse"))
                             .stream()
                             .map(course -> new CourseAllDTO(
                                     course.getId(),
                                     course.getName(),
                                     course.getThumb()
                                    )
                             )
                             .collect(Collectors.toList());
    
    }
    
    public Course getOneCourse(Long idCourse){
        
        
        
        Course course = courseRepository.findById(idCourse)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for ID: " + idCourse));
        
        
        return course;
        
    }
}
