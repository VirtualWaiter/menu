package com.virtualwaiter.menus.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "VWPRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_vwcategory", referencedColumnName = "id")
  private Category category;

  private Double price;
  private Integer stock;
  private String name;
  private String imageUrl;
  private Timestamp creationDate;
  private Timestamp modificationDate;

  @ManyToMany
  @JoinTable(
          name = "vwproduct_vwallergen",
          joinColumns = @JoinColumn(name = "id_vwproduct"),
          inverseJoinColumns = @JoinColumn(name = "id_vwallergen")
  )
  private List<Allergen> allergens;
}
