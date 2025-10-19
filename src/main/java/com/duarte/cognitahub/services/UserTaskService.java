/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import com.duarte.cognitahub.DTO.UserTask.CreateUserTaskDTO;
import com.duarte.cognitahub.DTO.UserTask.ListUserTaskDTO;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.models.UserTask;
import com.duarte.cognitahub.repositories.UserRepository;
import com.duarte.cognitahub.repositories.UserTaskRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */

@Service
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;
    private final UserRepository userRepository;
    
    public UserTaskService(UserTaskRepository userTaskRepository, UserRepository userRepository) {
        this.userTaskRepository = userTaskRepository;
        this.userRepository = userRepository;
    }
    
    public CreateUserTaskDTO saveTopic(UserTask userTask){
        
        UserTask userT = userTaskRepository.save(userTask);
        CreateUserTaskDTO userTDTO = new CreateUserTaskDTO(
                userTask.getUser().getId(),
                userTask.getTask().getId(),
                userTask.getFileTask()
        );         
        
        return userTDTO;
    }
    
    public List<UserTask> getAllTaskUser(){
        return userTaskRepository.findAll();
    }

    
    public List<ListUserTaskDTO> getUserTaskByUser(Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        
        return this.userTaskRepository.findByUser(user.orElseThrow())
                               .stream()
                               .map(userTask -> new ListUserTaskDTO( userTask ) )
                               .collect(Collectors.toList());
    
    }
    
}
