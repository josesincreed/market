package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {CategoryMapper.class}) // Se indica que se usará el CategoryMapper
public interface ProductMapper {

    // Mapeo de la clase Product a Producto
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);  //Mapea de Producto a Product
    List<Product> toProducts(List<Producto> productos); // Mapea una lista de Producto a Product

    @InheritInverseConfiguration  //Invierte el mapeo
    @Mapping(target = "codigoBarras", ignore = true) // Ignora el mapeo de codigoBarras
    Producto toProducto(Product product); // Mapea de Product a Producto
}
