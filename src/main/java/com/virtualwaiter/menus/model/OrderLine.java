package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VWORDERLINE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_vworder", referencedColumnName = "id")
  private Order order;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_vwproduct", referencedColumnName = "id")
  private Product product;

  private Integer quantity;
  private Double unitPrice;
  private Double subtotal;
  private Double taxPercentage;
  private Double total;
}
