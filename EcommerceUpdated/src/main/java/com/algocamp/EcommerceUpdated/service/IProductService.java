package com.algocamp.EcommerceUpdated.service;

import com.algocamp.EcommerceUpdated.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO createProduct(ProductDTO dto);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProduct();

    List<ProductDTO> getProductByIds(List<Long> ids);
}
