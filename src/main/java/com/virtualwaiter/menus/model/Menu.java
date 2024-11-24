package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "VWMENU")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

  @Id
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_vwrestaurant", referencedColumnName = "id")
  private Restaurant restaurant;

  @OneToMany(mappedBy = "menu")
  private List<Category> categories;
}
