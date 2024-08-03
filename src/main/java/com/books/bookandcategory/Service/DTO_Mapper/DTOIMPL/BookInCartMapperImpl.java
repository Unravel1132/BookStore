package com.books.bookandcategory.Service.DTO_Mapper.DTOIMPL;

import com.books.bookandcategory.DTO.BookInCartDTO;
import com.books.bookandcategory.Repository.BookRepository;
import com.books.bookandcategory.Repository.CartRepository;
import com.books.bookandcategory.Service.DTO_Mapper.BookInCartMapper;
import com.books.bookandcategory.model.BookEntity;
import com.books.bookandcategory.model.BookInCartEntity;
import com.books.bookandcategory.model.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookInCartMapperImpl implements BookInCartMapper {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public BookInCartEntity toBookInCart(BookInCartDTO cartDTO) {
        BookInCartEntity bookInCartEntity = new BookInCartEntity();
        bookInCartEntity.setId(cartDTO.getId());
        bookInCartEntity.setQuantity(cartDTO.getQuantity());

        if(cartDTO.getBookId() != null){
            BookEntity bookEntity = bookRepository.findById(cartDTO.getId()).orElseThrow(()->{
                throw new RuntimeException("Book not found");
            });
            bookInCartEntity.setBook(bookEntity);
        }
        if (cartDTO.getCartId() != null) {
            CartEntity cart = cartRepository.findById(cartDTO.getCartId())
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
            bookInCartEntity.setCart(cart);
        }
        return bookInCartEntity;
    }

    @Override
    public BookInCartDTO toBookInCartDTO(BookInCartEntity bookInCartEntity) {
        BookInCartDTO bookInCartDTO = new BookInCartDTO();
        bookInCartDTO.setId(bookInCartEntity.getId());
        bookInCartDTO.setQuantity(bookInCartEntity.getQuantity());
        bookInCartDTO.setBookId(bookInCartDTO.getBookId());
        bookInCartDTO.setCartId(bookInCartDTO.getCartId());
        return bookInCartDTO;
    }
}



