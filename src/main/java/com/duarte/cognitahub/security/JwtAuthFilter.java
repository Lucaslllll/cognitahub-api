/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.duarte.cognitahub.services.UserDetailsServiceNew;

/**
 *
 * @author Lucas
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter{
    private final UserDetailsServiceNew userDetailsService;

    public JwtAuthFilter(UserDetailsServiceNew userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }
        
        String token = authHeader.substring(7);
        String email = JwtUtil.extractEmail(token);
        
        // System.out.println("email.doFilterinternal.jwtauthfilter = "+email);
        
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            
//            UserDetails userDetails = userDetailsService.loadUserByUsername("dueto@gmail.com");
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if(JwtUtil.validateToken(token)){
            
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                
            }
            
            filterChain.doFilter(request, response);
        
        }
        
    }
    
    
    
}
