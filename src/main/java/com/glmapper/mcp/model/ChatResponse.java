package com.glmapper.mcp.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname ChatResponse
 * @Description TODO
 * @Date 2025/4/3 14:25
 * @Created by glmapper
 */
@Data
public class ChatResponse implements Serializable {

    private String content;

    public ChatResponse(String content) {
        this.content = content;
    }
}
