# MCP Sample Project

这是一个基于 Spring Boot 3 和 JDK 21 的 Model Context Protocol (MCP) 样例项目。
This is a Model Context Protocol (MCP) sample project based on Spring Boot 3 and JDK 21.

## 技术栈 / Tech Stack
- Spring Boot 3.2.3
- JDK 21
- Maven
- Lombok
- Jackson

## 功能特性 / Features
- 模型上下文创建 / Model Context Creation
- 上下文验证 / Context Validation
- 上下文丰富化 / Context Enrichment
- RESTful API 接口 / RESTful API Endpoints

## 运行项目 / Run the Project

1. 确保已安装 JDK 21 / Make sure JDK 21 is installed
2. 在项目根目录执行 / Execute in project root:
```bash
mvn spring-boot:run
```

## API 接口 / API Endpoints

### 创建上下文 / Create Context
```bash
POST http://localhost:8080/api/mcp/context?modelId=test-model&modelVersion=1.0.0
```

### 验证上下文 / Validate Context
```bash
POST http://localhost:8080/api/mcp/context/validate
Content-Type: application/json

{
    "modelId": "test-model",
    "modelVersion": "1.0.0",
    "contextId": "uuid",
    "timestamp": 1234567890
}
```

### 丰富上下文 / Enrich Context
```bash
POST http://localhost:8080/api/mcp/context/enrich?key=environment&value=production
Content-Type: application/json

{
    "modelId": "test-model",
    "modelVersion": "1.0.0",
    "contextId": "uuid",
    "timestamp": 1234567890
}
```

### 获取上下文 / Get Context
```bash
GET http://localhost:8080/api/mcp/context/{contextId}
```

## 项目结构 / Project Structure
```
src/main/java/com/example/mcp/
├── McpApplication.java
├── model/
│   └── ModelContext.java
├── protocol/
│   └── McpProtocolHandler.java
└── controller/
    └── McpController.java
``` 