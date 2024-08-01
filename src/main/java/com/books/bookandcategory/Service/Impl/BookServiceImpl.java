package com.books.bookandcategory.Service.Impl;

import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.Repository.BookRepository;
import com.books.bookandcategory.Repository.CategoryRepository;
import com.books.bookandcategory.Service.BookService;
import com.books.bookandcategory.Service.DTO_Mapper.BookMapper;
import com.books.bookandcategory.Service.DTO_Mapper.CategoryMapper;
import com.books.bookandcategory.model.BookEntity;
import com.books.bookandcategory.model.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
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
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found" + id));

        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setIsbn(bookDTO.getISBN());
        bookEntity.setId(bookDTO.getId());
        if (bookDTO.getCategory() != null) {
            CategoryEntity categoryEntity = categoryMapper.toCategory(bookDTO.getCategory());
            bookEntity.setCategory(categoryEntity);

        } else {
            bookEntity.setCategory(null);
        }
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        logger.info("Book with ID: {} successfully updated", id);
        return bookMapper.toBookDTO(savedBookEntity);
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found" + id);
        }
    }

    public List<BookDTO> searchBookByTitle(String title, String author) {
        List<BookEntity> bookEntities = new ArrayList<>();
        if ((title != null && !title.isEmpty()) && (author != null && !author.isEmpty())) {
            bookEntities.addAll(bookRepository.findByTitle(title, author));
        } else if (title != null && !title.isEmpty()) {
            bookEntities = bookRepository.findByTitle(title);
        } else if (author != null && !author.isEmpty()) {
            bookEntities = bookRepository.findByAuthor(author);
        }
        return bookEntities.stream().map(bookMapper::toBookDTO).collect(Collectors.toList());
    }
}
