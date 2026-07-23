package com.project.Helpdesk.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    private Logger logger = LoggerFactory.getLogger(AiConfig.class);
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository ) {

        // chat memory ka implementation khud de skte h

        var chatMemory = MessageWindowChatMemory.builder()
                        .chatMemoryRepository(jdbcChatMemoryRepository)
                        .maxMessages(24)
                        .build();

        logger.info("Initializing ChatClient.");
        logger.info("Initializing ChatMemory. {}", jdbcChatMemoryRepository.getClass().getName());

        return builder
                .defaultSystem("Summarize the response within 300 words.")
                .defaultAdvisors(new SimpleLoggerAdvisor(), MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();

    }

}
