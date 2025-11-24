package com.ashu.Ecommerce.gateway;

import com.ashu.Ecommerce.dto.CartDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICartGateway{

    @Override
    public List<CartDTO> getAllCarts() throws IOException {
        return List.of();
    }

    @Override
    public CartDTO getCartById(int id) throws IOException {
        return null;
    }
}
