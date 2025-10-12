/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;


import com.duarte.cognitahub.exceptions.EmailNotFoundException;
//import com.duarte.fitness.tracker.status.models.User;
import com.duarte.cognitahub.repositories.UserRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;


/**
 *
 * @author Lucas
 */
@Service
public class UserDetailsServiceNew implements UserDetailsService{
    
    private final UserRepository userRepository;
    
    
    private UserDetailsServiceNew(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String name) throws EmailNotFoundException {
        
        // System.out.println("=---->>> AAAAA : "+name);

        com.duarte.cognitahub.models.User user = userRepository.findByEmail(name)
                .orElseThrow(() -> new EmailNotFoundException("User Not Found"));
        
        return User.builder()
                .username(user.getEmail())
                .password(user.getPasswords())
                .roles("USER")
                .build();
        
    }
    
}