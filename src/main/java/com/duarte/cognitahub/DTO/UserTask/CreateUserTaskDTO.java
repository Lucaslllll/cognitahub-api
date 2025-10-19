/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.DTO.UserTask;

/**
 *
 * @author Lucas
 */

public class CreateUserTaskDTO {
    private Long userId;
    private Long taskId;
    private String fileTask;
    
    
    
    public CreateUserTaskDTO(Long userId, Long taskId, String fileTask){
        this.userId = userId;
        this.taskId = taskId;
        this.fileTask = fileTask;
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

    public String getFileTask() {
        return fileTask;
    }

    public void setFileTask(String fileTask) {
        this.fileTask = fileTask;
    }
    
    
    
}
