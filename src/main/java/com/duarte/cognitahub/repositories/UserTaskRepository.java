/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.repositories;

import com.duarte.cognitahub.models.Task;
import com.duarte.cognitahub.models.User;
import com.duarte.cognitahub.models.UserTask;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas
 */

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

    public List<UserTask> findByUser(User user);
    
    // findBy[Propriedade1]And[Propriedade2] =  UserTask tem propriedades chamadas user e task
    public Optional<UserTask> findByUserAndTask(User user, Task task);
    
}
