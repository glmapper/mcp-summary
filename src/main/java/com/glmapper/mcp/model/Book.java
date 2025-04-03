package com.glmapper.mcp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2025/4/3 14:16
 * @Created by glmapper
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;

    @NotBlank(message = "书名不能为空")
    private String title;

    @NotBlank(message = "分类不能为空")
    private String category;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotNull(message = "出版日期不能为空")
    @PastOrPresent(message = "出版日期不能是未来日期")
    private LocalDate publicationDate;

    @NotBlank(message = "ISBN编码不能为空")
    private String isbn;
}
