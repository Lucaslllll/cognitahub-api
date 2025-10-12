/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.fitness.tracker.status.controllers;

/**
 *
 * @author Lucas
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.EndpointLinksResolver;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpointDiscoverer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EndpointController {

    @Autowired
    private WebEndpointDiscoverer webEndpointDiscoverer;

    @GetMapping("/endpoints")
    public Map<String, Link> getAllEndpoints() {
        EndpointLinksResolver resolver = new EndpointLinksResolver(webEndpointDiscoverer.getEndpoints());
        return resolver.resolveLinks("/actuator");
    }
}
