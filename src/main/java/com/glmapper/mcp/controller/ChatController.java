package com.glmapper.mcp.controller;

import com.glmapper.mcp.model.ChatRequest;
import com.glmapper.mcp.model.ChatResponse;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 聊天控制器，处理AI聊天请求
 */
@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Resource
    private ChatClient chatClient;

    /**
     * 处理聊天请求，使用AI和MCP工具进行响应
     *
     * @param request 聊天请求
     * @return 包含AI回复的响应
     */
    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        try {
            // 创建用户消息
            String userMessage = request.getMessage();
            // 使用非流式API调用聊天
            String content = chatClient.prompt()
                    .user(userMessage)
                    .call()
                    .content();
            return ResponseEntity.ok(new ChatResponse(content));
        } catch (Exception e) {
            logger.error("Chat request failed", e);
            return ResponseEntity.ok(new ChatResponse("处理请求时出错: " + e.getMessage()));
        }
    }
} 