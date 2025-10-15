/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.services.TopicService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */

@RestController
public class TopicController {
    private final TopicService topicService;
    
    public TopicController(TopicService topicService){
        this.topicService = topicService;
    }
    
    @GetMapping("/topics")
    public List<Topic> topicAll(){
        return topicService.getTopics();
    }
}
