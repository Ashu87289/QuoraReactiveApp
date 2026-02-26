package com.algocamp.EcommerceUpdated.repository;

import com.algocamp.EcommerceUpdated.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

 /*   List<Product> findAll();

    List<Product> findAllByIdIn(List<Long> id);*/
}
