package com.ashu.Ecommerce.services;

import com.ashu.Ecommerce.dto.ProductDTO;

public interface IProductService {
    ProductDTO getProductById(Long id) throws Exception;
}
