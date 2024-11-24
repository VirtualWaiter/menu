package com.virtualwaiter.menus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VWADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneAddress {

  @Id
  private Long id;
  private String externalNumber;
  private String phoneNumber;
  private String mcrestaurant;
}
