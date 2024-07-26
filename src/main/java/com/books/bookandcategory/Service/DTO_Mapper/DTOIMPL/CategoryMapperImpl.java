package com.books.bookandcategory.Service.DTO_Mapper.DTOIMPL;

import com.books.bookandcategory.DTO.CategoryDTO;
import com.books.bookandcategory.Service.DTO_Mapper.CategoryMapper;
import com.books.bookandcategory.model.CategoryEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperImpl implements CategoryMapper {


    @Override
    public CategoryEntity toCategory(CategoryDTO categoryDTO) {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDTO.getName());

        return categoryEntity;
    }

    @Override
    public CategoryDTO toCategoryDTO(CategoryEntity category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
