package com.ashu.Ecommerce.services;

import com.ashu.Ecommerce.Mapper.CartMapper;
import com.ashu.Ecommerce.dto.CartDTO;
import com.ashu.Ecommerce.entity.Cart;
import com.ashu.Ecommerce.exception.ProductNotFoundException;
import com.ashu.Ecommerce.repository.CartRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public class CartServices implements ICartService{

    private final CartRepository repo;

    public CartServices(CartRepository repo) {
        this.repo = repo;
    }

    @Override
    public CartDTO getCartById(Long id) {

            return  repo.findById(id)
                    .map(CartMapper::toDto)
                    .orElseThrow(()-> new ProductNotFoundException("Product with id " + id + " Not Found."));

    }

    @Override
    public List<CartDTO> getAllCarts() throws IOException {
        return repo.findAll()
                .stream().map(CartMapper::toDto).toList();
    }


    public CartDTO createProduct(CartDTO dto){
       Cart saved =  repo.save(CartMapper.toEntity(dto));
        return CartMapper.toDto(saved);
    }
}
