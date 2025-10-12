/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author Lucas
 */
public class EmailNotFoundException extends AuthenticationException{
    
    public EmailNotFoundException(String msg){
        super(msg);
    }
    
}
