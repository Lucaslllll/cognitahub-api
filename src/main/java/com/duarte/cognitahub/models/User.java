/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsers;
    
    private String name;
    
    @Column(unique=true, nullable=false)
    private String email;
    
    @Column(nullable=false)
    private String passwords;
    
    private boolean isactive;
    
    User(){}
    
    public User(String username, String email, String passwords){
        this.name = username;
        this.email = email;
        this.passwords = passwords;
        this.isactive = false;
        
    }
    
    
    public Long getId() {
        return idUsers;
    }


    public String getName() {
        return name;
    }

    public void setUname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    
    public boolean isIsActive(){
        return isactive;
    }
    
}
