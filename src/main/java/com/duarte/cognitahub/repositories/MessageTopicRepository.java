/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.repositories;

import com.duarte.cognitahub.models.MessageTopic;
import com.duarte.cognitahub.models.Topic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas
 */
@Repository
public interface MessageTopicRepository extends JpaRepository<MessageTopic, Long>{

    List<MessageTopic> findByTopic(Topic topic);
    
    
}
