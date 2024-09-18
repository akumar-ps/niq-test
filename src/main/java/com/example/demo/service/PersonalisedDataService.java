
package com.example.demo.service;

import com.example.demo.dto.ProductArgs;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ShopperShelfDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface PersonalisedDataService {
  List<ProductDto> getProducts(String shopperId, String category, String brand);

  List<ProductDto> getProducts(ProductArgs productArgs);

  void save(ProductDto productDto);

  void saveShopperInfo(ShopperShelfDto productDto);
}
