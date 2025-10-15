/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.models.Article;
import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.services.ArticleService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Lucas
 */
@RestController
@RequestMapping("/user")
public class ArticleController {
    private final ArticleService articleService;
    
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }
    
    
    
    @GetMapping("/course/{id}/articles")
    public List<Article> getArticlesByCourse(@PathVariable("id") Long idCourse){
        
        return articleService.getArticlesByCourse(idCourse);
        
    }
    
   
    
    @GetMapping("/course/article/{articleId}")
    public ResponseEntity<Article> getOneArticleByCourse(@PathVariable("articleId") Long idArticle){
        Article article = articleService.getOneArticle(idArticle);
        
        return ResponseEntity.ok(article);
    }
    
    
    
    
    
}
