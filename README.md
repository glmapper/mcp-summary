# MCP Summary Project

这是一个基于 Spring Boot 3 和 JDK 21 的 Model Context Protocol (MCP) 项目。该项目旨在提供一个统一的模型上下文协议实现，支持多种模型服务的集成和管理。项目包含客户端SDK和服务端实现，并以天气服务、本地文件系统以及mysql 数据库作为示例展示如何使用MCP协议。

This is a Model Context Protocol (MCP) project based on Spring Boot 3 and JDK 21. The project aims to provide a unified model context protocol implementation, supporting integration and management of various model services. It includes both client SDK and server implementation, with a weather service as an example to demonstrate how to use the MCP protocol.

## 项目说明 / Project Description

### 主要特点 / Key Features
- 统一的模型上下文协议 / Unified Model Context Protocol
- 支持多种模型服务集成 / Multiple Model Service Integration Support
- 插件化设计 / Plugin-based Design
- 完整的客户端SDK / Complete Client SDK
- 丰富的示例实现 / Rich Example Implementations


## 项目模块 / Project Modules

### mcp-clients
- MCP 协议客户端实现 / MCP Protocol Client Implementation
- 基于 openai 协议的模型调用 / Model Invocation Based on OpenAI Protocol
- 支持多种 mcp server / Support for Multiple MCP Servers

### mcp-server-weather
- 天气服务示例实现 / Weather Service Example Implementation
- 完整的 MCP 协议实现 / Complete MCP Protocol Implementation

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

### 1. 克隆项目 / Clone the Project

```bash
git clone https://github.com/glmapper/mcp-summary.git
cd mcp-summary
```

### 2. 构建项目 / Build the Project
```bash
# 清理并安装所有模块 / Clean and install all modules
mvn clean install -DskipTests

# 如果需要运行测试 / If you want to run tests
mvn clean install
```

### 3. 运行服务 / Run the Services

#### 3.1 启动天气服务器 / Start Weather Server
```bash
cd mcp-server-weather
mvn spring-boot:run
```
服务将在 http://localhost:8081 启动 / Service will start at http://localhost:8081；通过 sse 协议推送天气数据。

#### 3.2 运行客户端示例 / Run Client Example
```bash
cd mcp-clients
mvn spring-boot:run
```

### 5. 验证安装 / Verify Installation
```bash
# 测试天气服务是否正常运行 / Test if weather service is running
curl http://localhost:8060/api/chat/ai?userInput="上海的天气如何？"
# 测试访问数据库，统计表数据量
curl http://localhost:8060/api/chat/ai?userInput="user 中有多少数据？"
# 测试本地文件，创建文件并写入文本
curl http://localhost:8060/api/chat/ai?userInput="请帮我创建一个ai.txt，并在里面写入 hello glmapper"
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

笔者当前使用 spring ai 1.0.0-M7 版本在 maven 仓库中还不存在，是本地编译的。

### 应用配置 / Application Configuration
查阅具体 module 的 application.yml 文件，了解具体的配置项和默认值。

## 开发指南 / Development Guide

### 添加新的服务 / Adding New Service
1. 创建新的服务模块 / Create new service module
2. 实现 MCP 协议接口 / Implement MCP protocol interface
3. 添加服务配置 / Add service configuration
4. 注册服务到主应用 / Register service to main application


## 贡献指南 / Contributing
1. Fork 项目 / Fork the project
2. 创建特性分支 / Create feature branch
3. 提交变更 / Commit changes
4. 推送到分支 / Push to branch
5. 创建 Pull Request / Create Pull Request

## 许可证 / License
[Apache License 2.0](LICENSE)

## 联系我 / Contact Me
- Issues: https://github.com/glmapper/mcp-summary/issues
- Email: glmapper_2018@163.com