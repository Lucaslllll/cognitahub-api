/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "MessageTopic")
public class MessageTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessageTopic;
    
    @Column(nullable = false, length = 128)
    private String name;
    
    private String details;
    
    private LocalDate date;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTopic", referencedColumnName = "idTopic")
    private Topic topic;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "author", referencedColumnName = "idUsers")
    private User author;
    
    public MessageTopic(){}
    
    public MessageTopic(String name, String details, LocalDate date, Topic topic, User author){
        this.name = name;
        this.details = details;
        this.date = date;
        this.topic = topic;
        this.author = author;
    }

    public Long getIdMessageTopic() {
        return idMessageTopic;
    }

    public void setIdMessageTopic(Long idMessageTopic) {
        this.idMessageTopic = idMessageTopic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    
    
}
