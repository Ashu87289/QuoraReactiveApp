package com.ashu.Ecommerce.services;

import com.ashu.Ecommerce.dto.CartDTO;
import com.ashu.Ecommerce.gateway.ICartGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CartService implements ICartService{


    private final ICartGateway iCartGateway;

    public CartService(@Qualifier("fakeStoreRestTemplateGateway") ICartGateway iCartGateway) {
        this.iCartGateway = iCartGateway;
    }

    @Override
    public List<CartDTO> getAllCarts() throws IOException {
        return iCartGateway.getAllCarts();
    }

    @Override
    public CartDTO getCartById(int id) throws IOException {
        return iCartGateway.getCartById(id);
    }
}
