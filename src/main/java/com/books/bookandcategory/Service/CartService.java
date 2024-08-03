package com.books.bookandcategory.Service;

import com.books.bookandcategory.DTO.BookInCartDTO;
import com.books.bookandcategory.DTO.CartDTO;
import com.books.bookandcategory.model.CartEntity;

public interface CartService {
    CartDTO createCart(CartDTO cartDTO);
    CartDTO getCartById(Long id);
    void deleteCart(Long id);
    void addBookToCart(BookInCartDTO bookInCartDTO);
    void removeBookFromCart(Long bookInCartId);
}
