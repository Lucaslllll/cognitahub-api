/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.repositories.TopicRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    
    public TopicService(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }
    
 
    public List<Topic> getTopics(){
        return topicRepository.findAll();
    }
    
}
