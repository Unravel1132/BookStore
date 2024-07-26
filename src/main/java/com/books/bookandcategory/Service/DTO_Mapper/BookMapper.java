package com.books.bookandcategory.Service.DTO_Mapper;

import com.books.bookandcategory.DTO.BookDTO;
import com.books.bookandcategory.model.BookEntity;


public interface BookMapper {

    BookEntity toBook(BookDTO bookDTO);
    BookDTO toBookDTO(BookEntity book);
}
