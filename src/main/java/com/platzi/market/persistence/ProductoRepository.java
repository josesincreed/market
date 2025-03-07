package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductoRepository implements ProductRepository {

    // Inyección de dependencias que tengan que ver con Spring
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    // Crud repository encuentra la lista de productos
    @Override //Override indica que lo usamos de la interfaz
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    // Crud repository encuentra una lista de productos, segun la categoria, en orden alfabético
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos)); // Optional.of() crea un objeto Optional
    }
    // query methods encuentra una lista de productos, segun la cantidad de stock y el estado
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods)); // Optional.map() aplica una función al valor si está presente
    }
    // Crud repository encuentra un producto por su id
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto)); // Optional.map() aplica una función al valor si está presente
    }
    
    // Crud repository guarda un producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product); // Mapea un product
        return mapper.toProduct(productoCrudRepository.save(producto)); // Guarda un producto
    } 
    
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId); // Elimina un producto
    }
    
}
