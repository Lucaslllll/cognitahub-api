/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.duarte.cognitahub.models.Course;

/**
 *
 * @author Lucas
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
