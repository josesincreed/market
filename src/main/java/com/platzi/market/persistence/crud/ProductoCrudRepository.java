package com.platzi.market.persistence.crud;


import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Query methods encuentra una lista de productos, segun la categoria, en orden alfabético
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Query methods encuentra una lista de productos, segun la cantidad de stock y el estado
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
