package com.books.bookandcategory.Repository;

import com.books.bookandcategory.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByTitle(String title, String author);
}
