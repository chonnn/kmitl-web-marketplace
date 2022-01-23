package com.kmit.mkp.mapper;

import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto mapToProductDto(Product product);
    List<ProductDto> mapToProductDtoList(List<Product> products);

    Product mapToProduct(ProductDto productDto);

}
