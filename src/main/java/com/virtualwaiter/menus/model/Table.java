package com.virtualwaiter.menus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@jakarta.persistence.Table(name = "VWTABLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Table {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_vwrestaurant", referencedColumnName = "id")
  private Restaurant restaurant;

  private Integer tableNumber;
  private String qrcode;


}
