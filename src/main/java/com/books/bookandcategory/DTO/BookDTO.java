package com.books.bookandcategory.DTO;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String ISBN;
    private CategoryDTO category;
}
