package com.books.bookandcategory.Controllers;


import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.Service.Impl.BookServiceImpl;
import com.books.bookandcategory.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookServiceImpl.getAllBooks());
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<BookDTO> addBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO bookEntity = bookServiceImpl.addBook(bookDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookEntity);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<BookDTO> putBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO bookEntity = bookServiceImpl.updateBook(bookDTO, id);
        return  ResponseEntity.status(HttpStatus.CREATED).body(bookEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
         bookServiceImpl.deleteBook(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBookByTitleAndAuthor(@RequestParam(required = false) String title,
                                                                    @RequestParam(required = false) String author) {
        return ResponseEntity.ok(bookServiceImpl.searchBookByTitle(title, author));
    }
}
