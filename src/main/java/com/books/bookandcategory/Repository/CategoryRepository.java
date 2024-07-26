package com.books.bookandcategory.Repository;

import com.books.bookandcategory.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByName(String name);
    CategoryEntity findByName(String categoryName);

}
