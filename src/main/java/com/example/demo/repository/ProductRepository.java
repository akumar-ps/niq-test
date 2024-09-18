
package com.example.demo.repository;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductArgs;
import com.example.demo.dto.ProductDto;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
  @Query(value = "select p from Product p where p.productId = :productId")
  Optional<Product> findProduct(@Param("productId") String productId);

  @Query(value = """
                 select p.* from shopper_shelf shelf
                 left join product p on p.product_id = shelf.product_id
                 where shelf.shopper_id = :#{#productArgs.shopperId}
                    and (:#{@queryUtil.checkNull(#productArgs.category)} = true or p.category = :#{#productArgs.category})
                    and (:#{@queryUtil.checkNull(#productArgs.brand)`1``} = true or p.brand = :#{#productArgs.brand})
                 """, nativeQuery = true)
  Page<Product> getProductByFilters(@NotNull Pageable pageable, @Param("productArgs") ProductArgs productArgs);
}
