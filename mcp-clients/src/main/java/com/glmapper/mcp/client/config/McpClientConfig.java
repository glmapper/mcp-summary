package com.glmapper.mcp.client.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname McpClientConfig
 * @Description TODO
 * @Date 2025/4/15 14:53
 * @Created by glmapper
 */
@Configuration
public class McpClientConfig {
    /**
     * 注入ChatClient
     *
     * @param chatModel
     * @param toolCallbackProvider 报红不用管，没有任何问题
     * @return
     */
    @Bean
    ChatClient chatClient(OpenAiChatModel chatModel, ToolCallbackProvider toolCallbackProvider) {
        return ChatClient.builder(chatModel).defaultTools(toolCallbackProvider.getToolCallbacks()).build();
    }
}
