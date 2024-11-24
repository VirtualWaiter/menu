package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Category category = new Category();

    //Then
    assertThat(category).isNotNull();
    assertThat(category.getId()).isNull();
    assertThat(category.getMenu()).isNull();
    assertThat(category.getName()).isNull();
    assertThat(category.getProducts()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    String name = "Entrantes";
    Menu menu = new Menu();
    List<Product> products = Arrays.asList(new Product());

    //When
    Category category = new Category(id, name, products, menu);

    //Then
    assertThat(category.getId()).isEqualTo(id);
    assertThat(category.getName()).isEqualTo(name);
    assertThat(category.getMenu()).isEqualTo(menu);
    assertThat(category.getProducts()).isEqualTo(products);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Category category = new Category();
    Menu menu = new Menu(1L, new Restaurant(), new ArrayList<Category>());
    List<Allergen> allergens = new ArrayList<>();
    Timestamp timestamp = Timestamp.from(Instant.now());

    Product product = new Product(1L, category, 2.85, 30, "Quesillo",
            "https://assets.elgourmet.com/wp-content/uploads/2023/03/quesi_1GKL9CDFU3guYfZskc6liq8OprHTQx-1024x683.png",
            timestamp, timestamp, allergens);


    //When
    category.setId(1L);
    category.setName("Entrantes");
    category.setMenu(menu);
    category.setProducts(Arrays.asList(product));

    //Then
    assertThat(category.getId()).isEqualTo(1L);
    assertThat(category.getName()).isEqualTo("Entrantes");

    // Comprobamos que el producto añadido tiene los valores esperados
    assertThat(category.getProducts()).hasSize(1);

    Product retrievedProduct = category.getProducts().get(0);
    assertThat(retrievedProduct.getId()).isEqualTo(1L);
    assertThat(retrievedProduct.getName()).isEqualTo("Quesillo");
    assertThat(retrievedProduct.getPrice()).isEqualTo(2.85);
    assertThat(retrievedProduct.getStock()).isEqualTo(30);
    assertThat(retrievedProduct.getImageUrl()).isEqualTo("https://assets.elgourmet.com/wp-content/uploads/2023/03/quesi_1GKL9CDFU3guYfZskc6liq8OprHTQx-1024x683.png");
    assertThat(retrievedProduct.getCreationDate()).isEqualTo(timestamp);
    assertThat(retrievedProduct.getModificationDate()).isEqualTo(timestamp);

    // Comprobamos que el menu añadido tiene los valores esperados
    Menu retrievedMenu = category.getMenu();
    assertThat(retrievedMenu.getId()).isEqualTo(1L);
  }
}
