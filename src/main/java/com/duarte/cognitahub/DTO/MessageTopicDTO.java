/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.DTO;

/**
 *
 * @author Lucas
 */
public class MessageTopicDTO {
    private Long idMessageTopic;
    private String name;
    private String details;
    private String date;
    private Long author;
    private Long idTopic;
    private UserDTO userDTO;
    
    public MessageTopicDTO(){
    
    }
    
    
    public MessageTopicDTO(Long idMessageTopic, String name, String details, String date, Long author, Long idTopic){
        this.idMessageTopic = idMessageTopic;
        this.name = name;
        this.details = details;
        this.date = date;
        this.author = author;
        this.idTopic = idTopic;
        
    }

    public MessageTopicDTO(String name, String details, String date, Long author, Long idTopic){
        this.name = name;
        this.details = details;
        this.date = date;
        this.author = author;
        this.idTopic = idTopic;
        
    }
    
    public MessageTopicDTO(String name, String details, String date, UserDTO userDTO, Long idTopic){
        this.name = name;
        this.details = details;
        this.date = date;
        this.userDTO = userDTO;
        this.idTopic = idTopic;
        
    }
    
    public MessageTopicDTO(Long idMessageTopic, String name, String details, String date, UserDTO userDTO, Long idTopic){
        this.idMessageTopic = idMessageTopic;
        this.name = name;
        this.details = details;
        this.date = date;
        this.userDTO = userDTO;
        this.idTopic = idTopic;
        
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    
    
}
