package com.example.productdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // Insert sample products
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> category(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min, @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sort products
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.sortByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.expensiveProducts(price);
    }
}