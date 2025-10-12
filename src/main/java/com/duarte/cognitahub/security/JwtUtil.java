package com.duarte.cognitahub.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;
import java.nio.charset.StandardCharsets;

import java.util.Date;
import java.security.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lucas
 */
@Component
public class JwtUtil {
    //private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    //@Value("${jwt.secret}")
    private static String jwtSecret = "dexterbayharborbutcher12345678901234";
    
    private static final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

    private static final long EXPIRATION_TIME = 86400000;
    
    
    
    public static String generateToken(String email){
        
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    
    }
    
    public static String extractEmail(String token){
        // debug
        //System.out.println("extractEmail.jwtutil before = "+token);
        //System.out.println("extractEmail.jwtutil after = "+Jwts.parserBuilder().setSigningKey(key).build()
        //        .parseClaimsJws(token).getBody().getSubject());
        
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    
    }
    
    public static boolean validateToken(String token){
        
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
          
            return true;
        
        }catch(JwtException e){
            
            return false;
        
        }
    }
    
}
