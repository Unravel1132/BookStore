package com.books.bookandcategory.Service;

import com.books.bookandcategory.DTO.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO addBook(BookDTO bookDTO, Long id);
    BookDTO updateBook(BookDTO bookDTO, Long id);
    void deleteBook(Long id);
}
