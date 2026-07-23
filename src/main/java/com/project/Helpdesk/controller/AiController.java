package com.project.Helpdesk.controller;

import com.project.Helpdesk.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
public class AiController {

    private final AIService aiService;

    @PostMapping
    public ResponseEntity<String> getResponseFromAssistant(@RequestBody String query, @RequestHeader("conversationId") String conversationId) {
        return ResponseEntity.ok(aiService.getResponseFromAssistant(query, conversationId));
    }

    @PostMapping("/stream")
    public Flux<String> streamResponse(@RequestBody String query, @RequestHeader("conversationId") String conversationId) {
        return aiService.streamResponseFromAssistant(query, conversationId);
    }
}
