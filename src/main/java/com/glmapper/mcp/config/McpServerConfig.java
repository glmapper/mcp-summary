package com.glmapper.mcp.config;

/**
 * @Classname McpServerConfig
 * @Description McpServerConfig
 * @Date 2025/4/3 14:20
 * @Created by glmapper
 */

import com.glmapper.mcp.service.BookService;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MCP服务器配置类，负责注册MCP工具
 */
@Configuration
public class McpServerConfig {

    /**
     * 注册工具回调提供者，将BookService中的@Tool方法暴露为MCP工具
     *
     * @param bookService 图书服务
     * @return 工具回调提供者
     */
    @Bean
    public MethodToolCallbackProvider bookToolCallbackProvider(BookService bookService) {
        return MethodToolCallbackProvider.builder().toolObjects(bookService).build();
    }
}
