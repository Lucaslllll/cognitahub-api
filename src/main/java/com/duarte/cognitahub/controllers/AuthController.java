/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.security.JwtUtil;
import com.duarte.cognitahub.services.UserService;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UserService userService;
    
    public AuthController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        
        User user = userService.saveUser(new User(request.get("username"), request.get("email"), request.get("password")));
        
        return ResponseEntity.ok(user);
    
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        
        Optional<User> user = userService.searchByEmail(request.get("email"));
        
        if(user.isPresent()){
            
            String token = userService.login(request.get("email"), request.get("password"));
            
            return ResponseEntity.ok(Map.of("token", token));
        }
        
        return ResponseEntity.status(401).body("Invalid Credentials");
        
    }
    
}
