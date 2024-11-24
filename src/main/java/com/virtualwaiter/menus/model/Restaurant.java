package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "VWRESTAURANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

  @Id
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_vwphoneaddress", referencedColumnName = "id")
  private PhoneAddress phoneAddress;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_vwaddress", referencedColumnName = "id")
  private Address address;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_vwrestaurantowner", referencedColumnName = "id")
  private RestaurantOwner restaurantOwner;

  private String name;
  private String email;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String cif;

  @OneToMany(mappedBy = "restaurant")
  private List<com.virtualwaiter.menus.model.Table> tables;
}
