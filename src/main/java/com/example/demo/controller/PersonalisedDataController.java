package com.example.demo.controller;

import com.example.demo.dto.ProductArgs;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ShopperShelfDto;
import com.example.demo.service.PersonalisedDataService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonalisedDataController {
  private PersonalisedDataService personalisedDataService;

  @Autowired
  PersonalisedDataController(PersonalisedDataService personalisedDataService) {
    this.personalisedDataService = personalisedDataService;
  }

  @GetMapping("/products")
  public List<ProductDto> getProductsByShopperId(
    @RequestParam String shopperId,
    @RequestParam(required = false) String category,
    @RequestParam(required = false) String brand,
    @RequestParam(required = false) int limit
  ) {
    ProductArgs productArgs = new ProductArgs();
    productArgs.setShopperId(shopperId);
    productArgs.setCategory(category);
    productArgs.setBrand(brand);
    productArgs.setLimit(limit);
    return personalisedDataService.getProducts(productArgs);
  }

  @PostMapping(value = "/product-meta-data", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> saveProductMetaData(@RequestBody ProductDto productDto) {
    personalisedDataService.save(productDto);
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @PostMapping(value = "/shopper-info", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> saveShopperInfo(
    @RequestBody ShopperShelfDto productDto
  ) {
    personalisedDataService.saveShopperInfo(productDto);
    return ResponseEntity.ok(Boolean.TRUE);
  }
}
