package com.algocamp.OrderService.client;

import com.algocamp.OrderService.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ProductDTO getProductById(Long productId){
        //not the best way > service Discovery > Netflix Eureka
        String url = "http://ECOMMERCEUPDATED/api/product/" + productId;
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url,ProductDTO.class);
        if(response.getBody() == null){
            throw new RuntimeException("Product not found with id : " + productId);
        }
        return response.getBody();
    }
}
