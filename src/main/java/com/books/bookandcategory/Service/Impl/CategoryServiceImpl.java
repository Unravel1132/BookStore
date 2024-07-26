package com.books.bookandcategory.Service.Impl;

import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.DTO.CategoryDTO;
import com.books.bookandcategory.Repository.CategoryRepository;
import com.books.bookandcategory.Service.CategoryService;
import com.books.bookandcategory.Service.DTO_Mapper.BookMapper;
import com.books.bookandcategory.Service.DTO_Mapper.CategoryMapper;
import com.books.bookandcategory.model.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private BookMapper bookMapper;
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);


    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        if (list.isEmpty()) {
            logger.info("Categories not found");
            return null;
        }
        logger.info("Categories found");
        return list.stream().map(categoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id).
                map(categoryMapper::toCategoryDTO).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new RuntimeException("Category name already exists");
        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDTO.getName());
        return categoryMapper.toCategoryDTO(categoryRepository.save(categoryEntity));
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Category not found");
        }
    }

    @Override
    public List<BookDTO> findBookByCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryEntity.getBooks().stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findByName(String categoryName) {
        if (categoryRepository.existsByName(categoryName)) {
            return categoryMapper.toCategoryDTO(categoryRepository.findByName(categoryName));
        }
        return null;
    }
}
