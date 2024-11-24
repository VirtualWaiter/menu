package com.virtualwaiter.menus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "VWALLERGEN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Allergen {

  @Id
  private Long id;
  private String imageUrl;
  private String name;

  @ManyToMany(mappedBy = "allergens")
  private List<Product> products;
}
