/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.DTO.UserTask;

import com.duarte.cognitahub.models.UserTask;

/**
 *
 * @author Lucas
 */
public class ListUserTaskDTO {
    private SimpleUserDTO user;
    private TaskDTO task;
    private String fileTask;
    private String fileTaskMarked;
    private Boolean isMarked;

    // Getters, Setters, Construtores

    public ListUserTaskDTO(UserTask userTask) {
        this.user = new SimpleUserDTO(userTask.getUser());
        this.task = new TaskDTO(userTask.getTask());
        this.fileTask = userTask.getFileTask();
        this.fileTaskMarked = userTask.getFileTaskMarked();
        this.isMarked = userTask.getIsMarked();
    }

    public String getFileTask() {
        return fileTask;
    }

    public void setFileTask(String fileTask) {
        this.fileTask = fileTask;
    }

    public String getFileTaskMarked() {
        return fileTaskMarked;
    }

    public void setFileTaskMarked(String fileTaskMarked) {
        this.fileTaskMarked = fileTaskMarked;
    }

    public Boolean getIsMarked() {
        return isMarked;
    }

    public void setIsMarked(Boolean isMarked) {
        this.isMarked = isMarked;
    }

    public SimpleUserDTO getUser() {
        return user;
    }

    public void setUser(SimpleUserDTO user) {
        this.user = user;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    

}
