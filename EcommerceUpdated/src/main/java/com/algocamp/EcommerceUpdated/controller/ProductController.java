package com.algocamp.EcommerceUpdated.controller;


import com.algocamp.EcommerceUpdated.dto.ProductDTO;
import com.algocamp.EcommerceUpdated.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productService;


    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO dto = this.productService.getProductById(id);
        return ResponseEntity.ok(dto);
    }


    /*Q :- Why GET is NOT ideal here?
    * Ans: If i use GET here Browser and URL Length Limits(~2kb - 8KB)
    * Large List of IDs break Requests
    * SecurityConcern Ids Appear in URL.
    * For Batch fetch POST is usefull bcz it allow Request Body. */
    @PostMapping("/batch")
    public ResponseEntity<List<ProductDTO>> getProductByIds(@RequestBody List<Long> ids){
        List<ProductDTO> dtos = this.productService.getProductByIds(ids);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> product = this.productService.getAllProduct();

        //  Wraps one single object into a List and its immutable list of size 1.
        //List<ProductDTO> products = Collections.singletonList(product);
        return ResponseEntity.ok(product);
    }
}
