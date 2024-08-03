package com.books.bookandcategory.Repository;

import com.books.bookandcategory.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
