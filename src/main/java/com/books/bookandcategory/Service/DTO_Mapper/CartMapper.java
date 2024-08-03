package com.books.bookandcategory.Service.DTO_Mapper;

import com.books.bookandcategory.DTO.CartDTO;
import com.books.bookandcategory.model.CartEntity;

public interface CartMapper {
    CartEntity toCart(CartDTO cart);
    CartDTO toCartDTO(CartEntity cart);
}
