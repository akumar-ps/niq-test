package com.example.demo.domain;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopper_shelf")
@Getter
@Setter
public class ShopperShelf {
  @Column(name = "shopper_id", nullable = false)
  private String shopperId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  private Product product;

  private Double relevancyScore;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
