package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @Column(nullable = false, unique = true, name = "product_id")
  private String productId;

  @Column(nullable = false)
  private String brand;

  @Column(nullable = false)
  private String category;
}
