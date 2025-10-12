/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;

import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Embeddable;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class UserTaskId implements Serializable{
    
    @Column(name = "idUsers")
    private Long userId;
    
    @Column(name = "idTask")
    private Long taskId;
    
    
    public UserTaskId(){}
    
    public UserTaskId(Long userId, Long taskId){
        this.userId = userId;
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    
    
    @Override
    public int hashCode(){
        return Objects.hash(userId, taskId);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof UserTaskId)) return false;
        UserTaskId that = (UserTaskId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(taskId, that.taskId);
    
    }

}
    