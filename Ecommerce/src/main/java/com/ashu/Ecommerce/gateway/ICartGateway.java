package com.ashu.Ecommerce.gateway;

import com.ashu.Ecommerce.dto.CartDTO;
import com.ashu.Ecommerce.dto.CartProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICartGateway {

    List<CartDTO> getAllCarts() throws IOException;

    CartDTO getCartById(int id) throws IOException;
}
