package com.ashu.Ecommerce.services;

import com.ashu.Ecommerce.dto.CartDTO;

import java.io.IOException;
import java.util.List;

public interface ICartService {
    List<CartDTO> getAllCarts() throws IOException;

    CartDTO getCartById(int id) throws IOException;
}
