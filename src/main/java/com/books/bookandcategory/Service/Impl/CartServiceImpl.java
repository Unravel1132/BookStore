package com.books.bookandcategory.Service.Impl;

import com.books.bookandcategory.DTO.BookInCartDTO;
import com.books.bookandcategory.DTO.CartDTO;
import com.books.bookandcategory.Repository.BookInCartRepository;
import com.books.bookandcategory.Repository.CartRepository;
import com.books.bookandcategory.Service.CartService;
import com.books.bookandcategory.Service.DTO_Mapper.BookInCartMapper;
import com.books.bookandcategory.Service.DTO_Mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookInCartRepository bookInCartRepository;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private BookInCartMapper bookInCartMapper;


    @Override
    public CartDTO createCart(CartDTO cartDTO) {

        return null;
    }

    @Override
    public CartDTO getCartById(Long id) {
        return null;
    }

    @Override
    public void deleteCart(Long id) {

    }

    @Override
    public void addBookToCart(BookInCartDTO bookInCartDTO) {

    }

    @Override
    public void removeBookFromCart(Long bookInCartId) {

    }
}
