package com.glmapper.mcp.rag.milvus;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname TestMilvusService
 * @Description TODO
 * @Date 2025/4/7 20:29
 * @Created by glmapper
 */
@Service
public class TestMilvusService {

    @Autowired
    private VectorStore vectorStore;

    @PostConstruct
    public void test() {
        // Perform operations with the vectorStore
        // For example, you can call methods on the vectorStore object
        // vectorStore.someMethod();
        // ...

        List<Document> documents = List.of(new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")), new Document("The World is Big and Salvation Lurks Around the Corner"), new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));

// Add the documents to Milvus Vector Store
        vectorStore.add(documents);

// Retrieve documents similar to a query
        List<Document> results = this.vectorStore.similaritySearch(SearchRequest.builder()
                .query("Spring")
                .topK(5)
                .build());

        System.out.println(results);
    }
}
