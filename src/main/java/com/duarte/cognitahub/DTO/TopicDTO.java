/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.DTO;

/**
 *
 * @author Lucas
 */
public class TopicDTO {
    private String name;
    private String details;
    private String date;
    private Long author;

    public TopicDTO(String name, String details, String date, Long author){
        this.name = name;
        this.details = details;
        this.date = date;
        this.author = author;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the author
     */
    public Long getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Long author) {
        this.author = author;
    }
    
}
