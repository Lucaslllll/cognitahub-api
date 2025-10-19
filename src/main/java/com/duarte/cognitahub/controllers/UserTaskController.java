/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.DTO.UserTask.CreateUserTaskDTO;
import com.duarte.cognitahub.DTO.UserTask.ListUserTaskDTO;
import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.models.Task;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.models.UserTask;
import com.duarte.cognitahub.services.TaskService;
import com.duarte.cognitahub.services.UserService;
import com.duarte.cognitahub.services.UserTaskService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Lucas
 */

@RestController
public class UserTaskController {
    private final UserService userService;
    private final TaskService taskService;
    private final UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService, UserService userService, TaskService taskService) {
        this.userTaskService = userTaskService;
        this.userService = userService;
        this.taskService = taskService;
    }
    
    
    
    @PostMapping(value = "/task/send", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CreateUserTaskDTO> createTaskToSend(
            @RequestParam("id_user") Long userId,
            @RequestParam("id_task") Long taskId,
            @RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String path_saved;

        try {
            String uploadDir = "media/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            path_saved = filePath.toString();

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        User user = userService.getUserById(userId);
        Task task = taskService.getTaskById(taskId);

        UserTask userTask = new UserTask(user, task, path_saved);
        CreateUserTaskDTO savedTaskDTO = userTaskService.saveTopic(userTask);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTaskDTO);
    }
    
    
    @GetMapping("/user/{id}/tasks/sended")
    public List<ListUserTaskDTO> getUserTaskByUser(@PathVariable("id") Long idUser){
        
        return userTaskService.getUserTaskByUser(idUser);
        
    }

}
