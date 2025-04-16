# MCP Summary Project

这是一个基于 Spring Boot 3 和 JDK 21 的 Model Context Protocol (MCP) 项目。该项目旨在提供一个统一的模型上下文协议实现，支持多种模型服务的集成和管理。项目包含客户端SDK和服务端实现，并以天气服务作为示例展示如何使用MCP协议。

This is a Model Context Protocol (MCP) project based on Spring Boot 3 and JDK 21. The project aims to provide a unified model context protocol implementation, supporting integration and management of various model services. It includes both client SDK and server implementation, with a weather service as an example to demonstrate how to use the MCP protocol.

## 项目说明 / Project Description

### 主要特点 / Key Features
- 统一的模型上下文协议 / Unified Model Context Protocol
- 支持多种模型服务集成 / Multiple Model Service Integration Support
- 插件化设计 / Plugin-based Design
- 完整的客户端SDK / Complete Client SDK
- 丰富的示例实现 / Rich Example Implementations

### 应用场景 / Use Cases
- 模型服务集成 / Model Service Integration
- 天气服务实现 / Weather Service Implementation
- AI模型调用 / AI Model Invocation
- 分布式服务集成 / Distributed Service Integration

## 项目模块 / Project Modules

### mcp-clients
- MCP 协议客户端实现 / MCP Protocol Client Implementation
- 支持多种调用方式 / Multiple Invocation Methods Support
- 内置连接池管理 / Built-in Connection Pool Management
- 完整的异常处理 / Complete Exception Handling

### mcp-server-weather
- 天气服务示例实现 / Weather Service Example Implementation
- 完整的 MCP 协议实现 / Complete MCP Protocol Implementation
- RESTful API 接口 / RESTful API Endpoints
- 可扩展的服务设计 / Extensible Service Design

## 技术栈 / Tech Stack

### 核心依赖 / Core Dependencies
```xml
<!-- Spring Boot -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.4.4</version>
</parent>

<!-- Spring AI -->
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-bom</artifactId>
    <version>1.0.0-M7</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>

<!-- Jackson -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.3</version>
</dependency>
```

### 开发环境 / Development Environment
- JDK 21+
- Maven 3.6+
- IDE 推荐: IntelliJ IDEA 2023.3+ / IDE Recommendation: IntelliJ IDEA 2023.3+
- 操作系统: 支持所有主流操作系统 / OS: All major operating systems supported

## 快速开始 / Quick Start

### 1. 环境准备 / Environment Setup
```bash
# 检查 Java 版本 / Check Java version
java -version  # 确保是 JDK 21+ / Ensure it's JDK 21+

# 检查 Maven 版本 / Check Maven version
mvn -version   # 确保是 3.6+ / Ensure it's 3.6+
```

### 2. 获取代码 / Get the Code
```bash
git clone https://github.com/your-username/mcp-summary.git
cd mcp-summary
```

### 3. 构建项目 / Build the Project
```bash
# 清理并安装所有模块 / Clean and install all modules
mvn clean install -DskipTests

# 如果需要运行测试 / If you want to run tests
mvn clean install
```

### 4. 运行服务 / Run the Services

#### 启动天气服务器 / Start Weather Server
```bash
cd mcp-server-weather
mvn spring-boot:run
```
服务将在 http://localhost:8080 启动 / Service will start at http://localhost:8080

#### 运行客户端示例 / Run Client Example
```bash
cd mcp-clients
mvn spring-boot:run
```

### 5. 验证安装 / Verify Installation
```bash
# 测试天气服务是否正常运行 / Test if weather service is running
curl http://localhost:8080/api/weather/current?city=Beijing
```

## 配置说明 / Configuration

### Maven 仓库配置 / Maven Repository Configuration
项目使用以下 Maven 仓库，请确保你的 settings.xml 中包含这些配置：
The project uses the following Maven repositories, please ensure your settings.xml includes these configurations:

```xml
<repositories>
    <!-- Spring Snapshots -->
    <repository>
        <id>spring-snapshots</id>
        <name>Spring Snapshots</name>
        <url>https://repo.spring.io/snapshot</url>
        <releases><enabled>false</enabled></releases>
    </repository>
    
    <!-- Central Portal Snapshots -->
    <repository>
        <name>Central Portal Snapshots</name>
        <id>central-portal-snapshots</id>
        <url>https://central.sonatype.com/repository/maven-snapshots/</url>
        <releases><enabled>false</enabled></releases>
        <snapshots><enabled>true</enabled></snapshots>
    </repository>
</repositories>
```

### 应用配置 / Application Configuration
在 `application.yml` 中配置以下属性：
Configure the following properties in `application.yml`:

```yaml
spring:
  application:
    name: mcp-summary
  profiles:
    active: dev

server:
  port: 8080

# MCP 配置 / MCP Configuration
mcp:
  client:
    pool:
      max-total: 100
      max-idle: 20
  server:
    weather:
      api-key: your-api-key
```

## 开发指南 / Development Guide

### 添加新的服务 / Adding New Service
1. 创建新的服务模块 / Create new service module
2. 实现 MCP 协议接口 / Implement MCP protocol interface
3. 添加服务配置 / Add service configuration
4. 注册服务到主应用 / Register service to main application

### 客户端调用示例 / Client Usage Example
```java
@Autowired
private McpClient mcpClient;

public void example() {
    McpRequest request = McpRequest.builder()
        .modelId("weather-model")
        .parameters(Map.of("city", "Beijing"))
        .build();
    
    McpResponse response = mcpClient.invoke(request);
    // 处理响应 / Handle response
}
```

## 问题排查 / Troubleshooting

### 常见问题 / Common Issues
1. 构建失败 / Build Failure
   - 检查 Maven 设置 / Check Maven settings
   - 确保网络连接 / Ensure network connectivity
   
2. 服务启动失败 / Service Start Failure
   - 检查端口占用 / Check port occupation
   - 验证配置文件 / Verify configuration files

### 日志配置 / Logging Configuration
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```

## 贡献指南 / Contributing
1. Fork 项目 / Fork the project
2. 创建特性分支 / Create feature branch
3. 提交变更 / Commit changes
4. 推送到分支 / Push to branch
5. 创建 Pull Request / Create Pull Request

## 许可证 / License
[Apache License 2.0](LICENSE)

## 联系我们 / Contact Us
- Issues: https://github.com/your-username/mcp-summary/issues
- Email: your-email@example.com
- 文档 / Documentation: https://your-username.github.io/mcp-summary

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