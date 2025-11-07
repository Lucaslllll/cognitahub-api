/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.DTO.TopicDTO;
import com.duarte.cognitahub.exceptions.ResourceNotFoundException;
import com.duarte.cognitahub.models.Article;
import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.repositories.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
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
                                     topic.getIdTopic(),
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
    
    public Topic getOneTopicPure(Long idTopic){
        
        Topic topic = topicRepository.findById(idTopic)
                      .orElseThrow(() -> new ResourceNotFoundException("Topic not found for ID: " + idTopic));
        
        
        return topic;
    }

    public TopicDTO getOneTopic(Long idTopic) {
        TopicDTO topicSaved = topicRepository.findById(idTopic)
                .map(topic -> new TopicDTO(
                        topic.getIdTopic(),
                        topic.getName(),
                        topic.getDetails(),
                        topic.getDate().toString(),
                        topic.getAuthor().getId()
                    )
                ).orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + idTopic));;
        
        return topicSaved;
    }
}
