/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.DTO.TopicDTO;
import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.services.TopicService;
import com.duarte.cognitahub.services.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */

@RestController
public class TopicController {
    private final TopicService topicService;
    private final UserService userService;
    
    public TopicController(TopicService topicService, UserService userService){
        this.topicService = topicService;
        this.userService = userService;
    }
    
    @GetMapping("/topics")
    public List<TopicDTO> topicAll(){
        return topicService.getTopicsDTO();
    }
    
    
    @PostMapping("/topic/create")
    public ResponseEntity<Topic> createTopic(@RequestBody Map<String, String> request){
        Long authorId = Long.parseLong(request.get("author"));
        User user = userService.getUserById(authorId);
        
        Topic topic = new Topic(
                request.get("name"),
                request.get("details"),
                LocalDate.parse(request.get("date")),
                user
        );
        
        Topic savedTopic = topicService.saveTopic(topic);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
          
    }
        
}
