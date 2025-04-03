package com.glmapper.mcp.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname ChatRequest
 * @Description TODO
 * @Date 2025/4/3 14:24
 * @Created by glmapper
 */
@Data
public class ChatRequest implements Serializable {
    private String message;

}
