package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {              // Devuelve una lista de productos
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) { // Devuelve un producto por su id
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) { // Devuelve una lista de productos por su categoria
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) { // Guarda un producto
        return productRepository.save(product);
    }

    public boolean delete(int productId) { // Elimina un producto buscando si existe o no
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }



}
