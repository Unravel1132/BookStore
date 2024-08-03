package com.books.bookandcategory.DTO;

import lombok.Data;

@Data
public class BookInCartDTO {
    private Long id;
    private Long bookId;
    private Long cartId;
    private int quantity;
}