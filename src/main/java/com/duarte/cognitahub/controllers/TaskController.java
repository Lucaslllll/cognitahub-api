/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.controllers;

import com.duarte.cognitahub.models.Course;
import com.duarte.cognitahub.models.Task;
import com.duarte.cognitahub.services.CourseService;
import com.duarte.cognitahub.services.TaskService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
public class TaskController {
    private final TaskService taskService;
    private final CourseService courseService;
    private static final String MEDIA_DIR = "media/pdf/lista-exercicio/";
    
    public TaskController(TaskService taskService, CourseService courseService) {
        this.taskService = taskService;
        this.courseService = courseService;
    }
    
    
    @GetMapping("/tasks")
    public List<Task> taskAll(){
        return taskService.getTasks();
    }
    
    
    @GetMapping("/tasks/course/{id}")
    public List<Task> getTaskByCourse(@PathVariable("id") Long idCourse){
        
        return taskService.getTaskByCourse(idCourse);
        
    }
    
    
    @GetMapping("/download/task/{nameFile}")
    public ResponseEntity<Resource> downloadArquivo(@PathVariable String nameFile) throws IOException {
        
        
        File file = new File(MEDIA_DIR + nameFile);

        if (!file.exists() || !file.isFile()) {
            return ResponseEntity.notFound().build();
        }
        
        // evitar acessos além
        if(nameFile.contains("..")){
            return ResponseEntity.badRequest().build();
        }
        
        Resource resource = new FileSystemResource(file);

        // genérico
        String tipo = "application/octet-stream"; 
        
        if (nameFile.endsWith(".pdf")){ 
            tipo = "application/pdf";
        
        }
        else if (nameFile.endsWith(".png")){ 
            tipo = "image/png";
        
        }
        else if (nameFile.endsWith(".jpg") || nameFile.endsWith(".jpeg")){
            tipo = "image/jpeg";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(tipo))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }
    
    
    

    
}
