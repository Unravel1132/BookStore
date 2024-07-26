package com.books.bookandcategory.Service.Impl;

import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.Repository.BookRepository;
import com.books.bookandcategory.Repository.CategoryRepository;
import com.books.bookandcategory.Service.BookService;
import com.books.bookandcategory.Service.DTO_Mapper.BookMapper;
import com.books.bookandcategory.model.BookEntity;
import com.books.bookandcategory.model.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private BookMapper bookMapper;
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        if (bookEntities.isEmpty()) {
            logger.info("not found");
        }
        return bookEntities.stream().map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Book not found" + id));
        return bookMapper.toBookDTO(bookEntity);
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO, Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found" + id));
        BookEntity bookEntity = bookMapper.toBook(bookDTO);
        bookEntity.setCategory(categoryEntity);
        return bookMapper.toBookDTO(bookRepository.save(bookEntity));
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long id) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
