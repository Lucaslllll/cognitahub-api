/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.models.Article;
import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.repositories.ArticleRepository;
import com.duarte.cognitahub.repositories.CourseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


/**
 *
 * @author Lucas
 */
@Service
public class ArticleService {
    
    private final ArticleRepository articleRepository;
    private final CourseRepository courseRepository;

    public ArticleService(ArticleRepository articleRepository, CourseRepository courseRepository) {
        this.articleRepository = articleRepository;
        this.courseRepository = courseRepository;
    }
    
    public List<Article> getArticlesByCourse(Long idCourse){
        Optional<Course> course = courseRepository.findById(idCourse);
        
        return this.articleRepository.findByCourse(course.orElseThrow());
        
    }
    
    public Article getOneArticle(Long idArticle){
        
        
        
        Article article = articleRepository.findById(idArticle)
                .orElseThrow(() -> new RuntimeException("Profile not found for user ID: " + idArticle));
        
        
        return article;
        
    }
    
}
