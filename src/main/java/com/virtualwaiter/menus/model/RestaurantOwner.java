package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VWRESTAURANTOWNER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantOwner {

  @Id
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_vwphoneaddress", referencedColumnName = "id")
  private PhoneAddress phoneAddress;

  private String name;
  private String email;
  private String idNumber;
  private String bankAccountNumber;
}
