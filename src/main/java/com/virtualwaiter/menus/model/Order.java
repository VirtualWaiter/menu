package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "VWORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_vwtable", referencedColumnName = "id")
  private com.virtualwaiter.menus.model.Table table;

  private Timestamp orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  private Double totalAmount;
  private Double commisionPercentage;
  private Double totalCommision;
  private Timestamp modifiedDate;

  @OneToMany(mappedBy = "order")
  private List<OrderLine> orderLines;

  public Double getTotalCommision() {
    // Calcula el porcentaje
    Double result = this.totalAmount * (this.commisionPercentage / 100);

    // Redondea a la centésima
    BigDecimal roundedResult = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP);

    return roundedResult.doubleValue();
  }
}
