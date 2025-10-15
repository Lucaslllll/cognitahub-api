package com.duarte.cognitahub.services;

import com.duarte.cognitahub.DTO.UserDTO;
import com.duarte.cognitahub.exceptions.EmailNotFoundException;
import com.duarte.cognitahub.exceptions.ResourceNotFoundException;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.repositories.UserRepository;
import com.duarte.cognitahub.security.JwtUtil;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService{
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtUtil jwtUtil;
    
    
    public UserService(UserRepository userRepository, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }
    
    
    
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    public List<UserDTO> getUsersDTO(){
        return userRepository.findAll()
                             .stream()
                             .map(user -> new UserDTO(user.getName(), user.getEmail()))
                             .collect(Collectors.toList());
        
    }
    
    public User getUserById(Long idUser){
        
        
        
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found for user ID: " + idUser));
        
        
        return user;
        
    }
    
    public Optional<User> searchByEmail(String email){
        return userRepository.findByEmail(email);
//                .orElseThrow(() -> new ResourceNotFoundException("User Not Found with EMAIL: "+email+""));
    }
    
    public User saveUser(User user){
        String passCripted = passwordEncoder.encode(user.getPasswords());
        
        User userSecure = new User(user.getName(), user.getEmail(), passCripted);
        
        return userRepository.save(userSecure);
    }
    
    public String login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new EmailNotFoundException("User not found"));

        if (!passwordEncoder.matches(rawPassword, user.getPasswords())) {
            throw new BadCredentialsException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
    
    
    public void deleteUser(Long id){
        if (! userRepository.existsById(id)){
            throw new ResourceNotFoundException("User With ID: "+id+" Not Found");
        }
        userRepository.deleteById(id);
        
    }
    
}