package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchReflectiveOperationException;

public class ProductTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Product product = new Product();

    //Then
    assertThat(product).isNotNull();
    assertThat(product.getId()).isNull();
    assertThat(product.getCategory()).isNull();
    assertThat(product.getPrice()).isNull();
    assertThat(product.getStock()).isNull();
    assertThat(product.getName()).isNull();
    assertThat(product.getImageUrl()).isNull();
    assertThat(product.getCreationDate()).isNull();
    assertThat(product.getModificationDate()).isNull();
    assertThat(product.getAllergens()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    Double price = 3.90;
    Integer stock = 80;
    String name = "Quesillo";
    String imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2Ao1Q7cHx6sgQVza2ZjxqflcFoBwzM3aLlw&s";
    Timestamp timestamp = Timestamp.from(Instant.now());

    Category category = new Category(1L, "Postres", Arrays.asList(new Product()), new Menu());
    List<Allergen> allergens = Arrays.asList(new Allergen(1L, "https://scu.ugr.es/pages/menu/alergenos/ficheros/Lacteos/!",
            "Lactosa", Arrays.asList(new Product())));

    //When
    Product product = new Product(id, category, price, stock, name, imageUrl, timestamp, timestamp, allergens);

    //Then
    assertThat(product.getId()).isEqualTo(id);
    assertThat(product.getImageUrl()).isEqualTo(imageUrl);
    assertThat(product.getName()).isEqualTo(name);
    assertThat(product.getImageUrl()).isEqualTo(imageUrl);
    assertThat(product.getCreationDate()).isEqualTo(timestamp);
    assertThat(product.getModificationDate()).isEqualTo(timestamp);
    assertThat(product.getCategory()).isEqualTo(category);
    assertThat(product.getAllergens()).isEqualTo(allergens);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Product product = new Product();
    Timestamp timestamp = Timestamp.from(Instant.now());

    Category category = new Category(1L, "Postres", Arrays.asList(new Product()), new Menu());

    List<Allergen> allergens = Arrays.asList(new Allergen(1L, "https://scu.ugr.es/pages/menu/alergenos/ficheros/Lacteos/!",
            "Lactosa", Arrays.asList(new Product())));


    //When
    product.setId(1L);
    product.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2Ao1Q7cHx6sgQVza2ZjxqflcFoBwzM3aLlw&s");
    product.setName("Quesillo");
    product.setCreationDate(timestamp);
    product.setModificationDate(timestamp);
    product.setCategory(category);
    product.setAllergens(allergens);

    //Then
    assertThat(product.getId()).isEqualTo(1L);
    assertThat(product.getImageUrl()).isEqualTo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2Ao1Q7cHx6sgQVza2ZjxqflcFoBwzM3aLlw&s");
    assertThat(product.getName()).isEqualTo("Quesillo");
    assertThat(product.getCreationDate()).isEqualTo(timestamp);
    assertThat(product.getModificationDate()).isEqualTo(timestamp);

    // Comprobamos que la categoría añadida tiene los valores esperados
    Category retrievedCategory = product.getCategory();
    assertThat(retrievedCategory.getId()).isEqualTo(1L);
    assertThat(retrievedCategory.getName()).isEqualTo("Postres");

    //Comprobamos que los alérgenos añadidos tienen los valores esperados
    assertThat(product.getAllergens()).hasSize(1);
    Allergen allergen = product.getAllergens().get(0);
    assertThat(allergen.getId()).isEqualTo(1L);
    assertThat(allergen.getImageUrl()).isEqualTo("https://scu.ugr.es/pages/menu/alergenos/ficheros/Lacteos/!");
    assertThat(allergen.getName()).isEqualTo("Lactosa");

  }
}
