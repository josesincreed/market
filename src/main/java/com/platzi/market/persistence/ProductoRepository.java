package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    // Crud repository encuentra la lista de productos
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
    //Query methods encuentra una lista de productos, segun la categoria, en orden alfabético
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    //Query methods encuentra una lista de productos, segun la cantidad de stock y el estado
    public Optional<List<Producto>> getEscasos(int cantidadStock, boolean estado) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado);
    }
    // Crud repository encuentra un producto por su id
    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }
    // Crud repository guarda un producto
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }
    // Crud repository elimina un producto
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
