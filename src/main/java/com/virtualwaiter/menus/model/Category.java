package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "VWCATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

  @Id
  private Long id;

  private String name;

  @OneToMany(mappedBy = "category")
  private List<Product> products;

  @ManyToOne
  @JoinColumn(name = "id_vwmenu", referencedColumnName = "id")
  private Menu menu;
}
