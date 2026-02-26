package com.algocamp.EcommerceUpdated.repository;

import com.algocamp.EcommerceUpdated.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    /*Category findByid(Long id);

    @Override
    boolean existsById(Long id);*/

    Optional<Category> findByName(String name);
}
