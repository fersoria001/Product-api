package com.emerald.blue.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerald.blue.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByNameIs(String name);
}
