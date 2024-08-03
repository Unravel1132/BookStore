package com.books.bookandcategory.Service.DTO_Mapper.DTOIMPL;

import com.books.bookandcategory.DTO.CartDTO;
import com.books.bookandcategory.Service.DTO_Mapper.CartMapper;
import com.books.bookandcategory.model.CartEntity;
import org.springframework.stereotype.Service;

@Service
public class CartMapperImpl implements CartMapper {

    @Override
    public CartEntity toCart(CartDTO cart) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(cart.getId());
        cartEntity.setCustomerName(cart.getCustomerName());
        return cartEntity;
    }

    @Override
    public CartDTO toCartDTO(CartEntity cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setCustomerName(cart.getCustomerName());
        return cartDTO;
    }
}
