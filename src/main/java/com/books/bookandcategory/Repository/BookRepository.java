package com.books.bookandcategory.Repository;

import com.books.bookandcategory.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
