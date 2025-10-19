/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users_has_Task")
public class UserTask {
    
    @EmbeddedId
    private UserTaskId id = new UserTaskId();

    @ManyToOne(optional = false)
    @MapsId("userId")
    @JoinColumn(name = "idUsers")
    private User user;
    
    @ManyToOne(optional = false)
    @MapsId("taskId")
    @JoinColumn(name = "idTask")
    private Task task;
    
    @Column(name = "file_task", length = 128)
    private String fileTask;
    
    @Column(name = "file_task_marked", length = 128)
    private String fileTaskMarked;
    
    private Boolean isMarked = false;
    
    public UserTask() {}
    
    public UserTask(User user, Task task){
        this.user = user;
        this.task = task;
        this.id = new UserTaskId(user.getId(), task.getId());
    }
    
    public UserTask(User user, Task task, String fileTask) {
        this.user = user;
        this.task = task;
        this.id = new UserTaskId(user.getId(), task.getId());
        this.fileTask = fileTask;
        
    }
    
    public UserTask(User user, Task task, String fileTask, String fileTaskMarked, Boolean isMarked) {
        this.user = user;
        this.task = task;
        this.id = new UserTaskId(user.getId(), task.getId());
        this.fileTask = fileTask;
        this.fileTaskMarked = fileTaskMarked;
        this.isMarked = isMarked;
    }  

    public UserTaskId getId() {
        return id;
    }

    public void setId(UserTaskId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.id.setUserId(user.getId());
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
        this.id.setTaskId(task.getId());
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
    
    
    
    
}
