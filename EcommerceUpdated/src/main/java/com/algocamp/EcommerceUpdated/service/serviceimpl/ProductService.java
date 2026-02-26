package com.algocamp.EcommerceUpdated.service.serviceimpl;

import com.algocamp.EcommerceUpdated.dto.ProductDTO;
import com.algocamp.EcommerceUpdated.entity.Category;
import com.algocamp.EcommerceUpdated.entity.Product;
import com.algocamp.EcommerceUpdated.mapper.ProductMapper;
import com.algocamp.EcommerceUpdated.repository.CategoryRepository;
import com.algocamp.EcommerceUpdated.repository.ProductRepository;
import com.algocamp.EcommerceUpdated.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Category category = this.categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found with id : " + dto.getCategoryId()));

        //Map dto to entity(simple fields)
        Product product = productMapper.toEntity(dto);

        //set relationship
        product.setCategory(category);

        //save
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(()->new RuntimeException());
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> product = productRepository.findAll();
        return  product.stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDTO> getProductByIds(List<Long> ids) {
        return productRepository.findAllById(ids)
                .stream().map(productMapper::toDto)
                .toList();
    }
}
