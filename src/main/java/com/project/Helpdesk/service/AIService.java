package com.project.Helpdesk.service;

import com.project.Helpdesk.tool.EmailTool;
import com.project.Helpdesk.tool.TicketDBTool;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Data
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    private final TicketDBTool  ticketDBTool;

    private final EmailTool  emailTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;

    public String getResponseFromAssistant(String query, String conversationId){
           return this.chatClient
                   .prompt()
                   .advisors(advisorSpec -> advisorSpec
                           .param(ChatMemory.CONVERSATION_ID, conversationId)
                   )
                   .tools(ticketDBTool, emailTool)
                   .system(systemPromptResource)
                   .user(query)
                   .call()
                   .content();
    }

    public Flux<String> streamResponseFromAssistant(String query, String conversationId) {
        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec
                        .param(ChatMemory.CONVERSATION_ID, conversationId)
                )
                .tools(ticketDBTool, emailTool)
                .system(systemPromptResource)
                .user(query)
                .stream()
                .content();
    }
}
