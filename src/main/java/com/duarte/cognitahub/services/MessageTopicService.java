/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.DTO.MessageTopicDTO;
import com.duarte.cognitahub.DTO.UserDTO;
import com.duarte.cognitahub.models.MessageTopic;
import com.duarte.cognitahub.models.Topic;
import com.duarte.cognitahub.repositories.MessageTopicRepository;
import com.duarte.cognitahub.repositories.TopicRepository;
import com.duarte.cognitahub.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class MessageTopicService {
   private final MessageTopicRepository messageTopicRepository;
   private final UserRepository userRepository;
   private final TopicRepository topicRepository;
   
   public MessageTopicService(MessageTopicRepository messageTopicRepository, UserRepository userRepository, TopicRepository topicRepository){
       this.messageTopicRepository = messageTopicRepository;
       this.userRepository = userRepository;
       this.topicRepository = topicRepository;
   
   }
   
   public MessageTopic saveMessageTopic(MessageTopic messageTopic){
        
        MessageTopic msgT = messageTopicRepository.save(messageTopic);
        
        return msgT;
    }
   
   
   public List<MessageTopicDTO> getMessageTopicByTopic(Long idTopic) {
        Optional<Topic> topic = topicRepository.findById(idTopic);
        
        List<MessageTopicDTO> msgTDTO = messageTopicRepository.findByTopic(topic.orElseThrow())
                .stream()
                .map( messageTopic -> new MessageTopicDTO(
                        messageTopic.getIdMessageTopic(),
                        messageTopic.getName(),
                        messageTopic.getDetails(),
                        messageTopic.getDate().toString(),
                        new UserDTO(messageTopic.getAuthor().getName(), messageTopic.getAuthor().getEmail()),
                        messageTopic.getTopic().getIdTopic()
                    )
                ).collect(Collectors.toList());
        
        return msgTDTO;
        
    }
   
   
}
