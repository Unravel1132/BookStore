package com.books.bookandcategory.Service.DTO_Mapper;

import com.books.bookandcategory.DTO.BookInCartDTO;
import com.books.bookandcategory.model.BookInCartEntity;

public interface BookInCartMapper {
    BookInCartEntity toBookInCart(BookInCartDTO cartDTO);
    BookInCartDTO toBookInCartDTO(BookInCartEntity bookInCartEntity);
}
