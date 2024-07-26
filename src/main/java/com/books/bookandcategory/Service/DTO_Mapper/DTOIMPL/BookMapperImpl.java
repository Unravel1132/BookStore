package com.books.bookandcategory.Service.DTO_Mapper.DTOIMPL;

import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.Service.DTO_Mapper.BookMapper;
import com.books.bookandcategory.model.BookEntity;
import org.springframework.stereotype.Service;

@Service
public class BookMapperImpl implements BookMapper {


    @Override
    public BookEntity toBook(BookDTO bookDTO) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.getId());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setIsbn(bookDTO.getISBN());
        return bookEntity;
    }

    @Override
    public BookDTO toBookDTO(BookEntity book) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setISBN(book.getIsbn());
        return bookDTO;
    }
}
