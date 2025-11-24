package com.ashu.Ecommerce.gateway;

import com.ashu.Ecommerce.dto.ProductDTO;

public interface IProductGateway {
    ProductDTO getProductById(Long id) throws Exception;
}
