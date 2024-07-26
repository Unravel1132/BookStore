package com.books.bookandcategory.Controllers;


import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.DTO.CategoryDTO;
import com.books.bookandcategory.Service.Impl.BookServiceImpl;
import com.books.bookandcategory.Service.Impl.CategoryServiceImpl;
import com.books.bookandcategory.model.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoryController {


    private final CategoryServiceImpl categoryServiceImpl;


    @Autowired
    public CategoryController(CategoryServiceImpl categoryServiceImpl, BookServiceImpl bookServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllBooks() {
        return ResponseEntity.ok(categoryServiceImpl.getAllCategory());
    }

    @GetMapping("/bookByCategory")
    public ResponseEntity<List<BookDTO>> getBooksByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryServiceImpl.findBookByCategory(id));
    }

    @GetMapping("/categoryByName")
    public ResponseEntity<CategoryDTO> categoryByName(@RequestParam String name) {
        return ResponseEntity.ok(categoryServiceImpl.findByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = categoryServiceImpl.addCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCategory(Long id) {
        categoryServiceImpl.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
