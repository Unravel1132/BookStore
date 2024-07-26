package com.books.bookandcategory.Service;

import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    void deleteCategoryById(Long id);
    List<BookDTO> findBookByCategory(Long id);
    CategoryDTO findByName(String categoryName);

}
