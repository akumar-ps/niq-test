package com.example.demo.mapper;

import com.example.demo.domain.Product;
import com.example.demo.domain.ShopperShelf;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ShopperShelfDto;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {
  ProductDto toProductDto(Product product);

  List<ProductDto> toDto(List<Product> ProductEntity);

  @Mapping(source = "productId", target = "productId")
  @Mapping(source = "brand", target = "brand")
  @Mapping(source = "category", target = "category")
  Product toProductEntity(ProductDto productDto);
}
