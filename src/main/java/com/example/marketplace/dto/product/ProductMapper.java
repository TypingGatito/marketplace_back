package com.example.marketplace.dto.product;

import com.example.marketplace.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
abstract public class ProductMapper {
    public abstract ProductDto toDto(Product product);

    @Mapping(target = "id", ignore = true)
    public abstract Product toEntity(ProductDto productDto);
}
