/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.DTO.UserDTO;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.services.GroqService;
import com.duarte.cognitahub.services.UserService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */
@RestController
public class UserController {
    private final UserService userService;
    private final GroqService groqService;
    
    
    public UserController(UserService userService, GroqService groqService) {
        this.userService = userService;
        this.groqService = groqService;
        
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId){
        User user = userService.getUserById(userId);
        
        return ResponseEntity.ok(new UserDTO(user.getName(), user.getEmail()));
    }
    
   
    @PostMapping("/user/api/chatbot")
    public Map<String, String> chat(@RequestBody Map<String, String> req) {
        String reply = groqService.chat(req.get("message"));
        return Map.of("reply", reply);
    }
    
}
