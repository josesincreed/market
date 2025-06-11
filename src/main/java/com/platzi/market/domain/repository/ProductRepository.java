package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    // Methods
    List<Product> getAll(); // Get all products
    Optional<List<Product>> getByCategory(int categoryId); // Get products by category
    Optional<List<Product>> getScarseProducts(int quantity); // Get scarce products
    Optional<Product> getProduct(int productId); // Get a product
    Product save(Product product); // Save a product
    void delete(int productId); // Delete a product


}
