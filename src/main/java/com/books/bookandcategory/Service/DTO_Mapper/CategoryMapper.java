package com.books.bookandcategory.Service.DTO_Mapper;

import com.books.bookandcategory.DTO.CategoryDTO;
import com.books.bookandcategory.model.CategoryEntity;
import jdk.jfr.Category;

public interface CategoryMapper {

    CategoryEntity toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDTO(CategoryEntity category);
}
