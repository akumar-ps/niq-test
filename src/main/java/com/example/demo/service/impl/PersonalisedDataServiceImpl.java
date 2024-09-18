package com.example.demo.service.impl;

import com.example.demo.dao.PersonalisedDataDao;
import com.example.demo.dto.ProductArgs;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ShopperShelfDto;
import com.example.demo.service.PersonalisedDataService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PersonalisedDataServiceImpl implements PersonalisedDataService {
  private final PersonalisedDataDao personalisedDataDao;

  PersonalisedDataServiceImpl(PersonalisedDataDao personalisedDataDao) {
    this.personalisedDataDao = personalisedDataDao;
  }

  @Override
  public List<ProductDto> getProducts(String shopperId, String category, String brand) {
    return personalisedDataDao.getProducts(shopperId, category, brand);
  }

  @Override
  public List<ProductDto> getProducts(ProductArgs productArgs) {
    return personalisedDataDao.getProducts(productArgs);
  }

  @Override
  public void save(ProductDto productDto) {
    personalisedDataDao.save(productDto);
  }

  @Override
  public void saveShopperInfo(ShopperShelfDto shopperShelfDto) {
    personalisedDataDao.saveShopperInfo(shopperShelfDto);
  }
}
