/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.DTO.MessageTopicDTO;
import com.duarte.cognitahub.models.MessageTopic;
import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.services.MessageTopicService;
import com.duarte.cognitahub.services.TopicService;
import com.duarte.cognitahub.services.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */


@RestController
public class MessageTopicController {
    private final MessageTopicService messageTopicService;
    private final TopicService topicService;
    private final UserService userService;

    public MessageTopicController(MessageTopicService messageTopicService, TopicService topicService, UserService userService) {
        this.messageTopicService = messageTopicService;
        this.topicService = topicService;
        this.userService = userService;
        
    }
    
    
    @PostMapping("/topic/message/create")
    public ResponseEntity<MessageTopicDTO> createMessageTopic(@RequestBody Map<String, String> request){
        Long author = Long.parseLong(request.get("author"));
        Long idTopic = Long.parseLong(request.get("topicId"));
        
        Topic topic = topicService.getOneTopicPure(idTopic);
        User user = userService.getUserById(author);
        
        MessageTopic msg = new MessageTopic(
                request.get("name"),
                request.get("details"),
                LocalDate.parse(request.get("date")),
                topic,
                user      
        );
        
        MessageTopic savedMsgT = messageTopicService.saveMessageTopic(msg);
        
        return ResponseEntity.ok(
            new MessageTopicDTO(
                savedMsgT.getName(),
                savedMsgT.getDetails(),
                savedMsgT.getDate().toString(),
                savedMsgT.getAuthor().getId(),
                savedMsgT.getTopic().getIdTopic()
            )
        );
    
    }
    
    
    @GetMapping("/topic/messages/{topicId}")
    public List<MessageTopicDTO> getUserTaskByUser(@PathVariable("topicId") Long topicId){
        
        return messageTopicService.getMessageTopicByTopic(topicId);
        
    }
    
}
