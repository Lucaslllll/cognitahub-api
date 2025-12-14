/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author Lucas
 */

@Service
public class GroqService {
    private final WebClient webClient;

    public GroqService( @Value("${groq.api.key}") String apiKey ) {
        this.webClient = WebClient.builder()
            .baseUrl("https://api.groq.com/openai/v1")
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .defaultHeader("Content-Type", "application/json")
            .build();
    }

    public String chat(String message) {
        Map<String, Object> body = Map.of(
            "model", "openai/gpt-oss-20b",
            "messages", List.of(
                Map.of("role", "user", "content", message)
            )
        );

        return webClient.post()
            .uri("/chat/completions")
            .bodyValue(body)
            .retrieve()
            .bodyToMono(Map.class)
            .map(resp -> {
                List<Map<String, Object>> choices = (List<Map<String, Object>>) resp.get("choices");
                Map<String, Object> msg = (Map<String, Object>) choices.get(0).get("message");

                return msg.get("content").toString();
            })
            .block();
    }
}
