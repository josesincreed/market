package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Mapeo de la clase Category a Categoria
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria); // Mapea de Categoria a Category

    @InheritInverseConfiguration  // Invierte el mapeo
    @Mapping(target = "productos", ignore = true) // Ignora el mapeo de productos
    Categoria toCategoria(Category category);

}
