package com.glmapper.mcp.repository;

import com.glmapper.mcp.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BookRepository
 * @Description BookRepository
 * @Date 2025/4/3 14:29
 * @Created by glmapper
 */
@Component
public class BookRepository {

    private static List<Book> books = new ArrayList<>();

    public void saveAll(List<Book> bookList) {
        books.addAll(bookList);
    }

    public List<Book> findByTitleContaining(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equals(category)) {
                result.add(book);
            }
        }
        return result;
    }
}
