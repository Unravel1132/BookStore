package com.books.bookandcategory.Repository;

import com.books.bookandcategory.model.BookInCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInCartRepository extends JpaRepository<BookInCartEntity, Long> {
}
