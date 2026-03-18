package com.example.productdemo;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    // Derived query methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Queries

    @Query("SELECT p FROM Product p ORDER BY p.price")
    List<Product> sortByPrice();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> expensiveProducts(@Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> productsByCategory(@Param("category") String category);
}