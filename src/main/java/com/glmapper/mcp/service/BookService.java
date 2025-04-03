package com.glmapper.mcp.service;

import com.glmapper.mcp.model.Book;
import com.glmapper.mcp.repository.BookRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname BookService
 * @Description BookService
 * @Date 2025/4/3 14:14
 * @Created by glmapper
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Tool(name = "findBooksByTitle", description = "根据书名模糊查询图书，支持部分标题匹配")
    public List<Book> findBooksByTitle(@ToolParam(description = "书名关键词") String title) {
        return bookRepository.findByTitleContaining(title);
    }


    @Tool(name = "findBooksByAuthor", description = "根据作者精确查询图书")
    public List<Book> findBooksByAuthor(@ToolParam(description = "作者姓名") String author) {
        return bookRepository.findByAuthor(author);
    }


    @Tool(name = "findBooksByCategory", description = "根据图书分类精确查询图书")
    public List<Book> findBooksByCategory(@ToolParam(description = "图书分类") String category) {
        return bookRepository.findByCategory(category);
    }
}
