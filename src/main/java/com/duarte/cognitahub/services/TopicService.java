/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.DTO.TopicDTO;
import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.repositories.TopicRepository;
import java.util.List;
import java.util.stream.Collectors;
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
    
    public List<TopicDTO> getTopicsDTO(){
        return topicRepository.findAll()
                             .stream()
                             .map(topic -> new TopicDTO(
                                     topic.getName(), 
                                     topic.getDetails(), 
                                     topic.getDate().toString(),
                                     topic.getAuthor().getId()
                                    )
                             )
                             .collect(Collectors.toList());
        
    }
    
    
    public Topic saveTopic(Topic topic){
        
        return topicRepository.save(topic);
    }
}
