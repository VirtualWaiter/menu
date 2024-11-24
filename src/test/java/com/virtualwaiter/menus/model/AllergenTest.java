package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllergenTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Allergen allergen = new Allergen();

    //Then
    assertThat(allergen).isNotNull();
    assertThat(allergen.getId()).isNull();
    assertThat(allergen.getImageUrl()).isNull();
    assertThat(allergen.getName()).isNull();
    assertThat(allergen.getProducts()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    String imageUrl = "https://scu.ugr.es/pages/menu/alergenos/ficheros/Lacteos/!";
    String name = "Lactosa";
    List<Product> products = Arrays.asList(new Product(1L, new Category(), 2.85, 30, "Quesillo",
            "https://assets.elgourmet.com/wp-content/uploads/2023/03/quesi_1GKL9CDFU3guYfZskc6liq8OprHTQx-1024x683.png",
            Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), new ArrayList<Allergen>()));

    //When
    Allergen allergen = new Allergen(id, imageUrl, name, products);

    //Then
    assertThat(allergen.getId()).isEqualTo(id);
    assertThat(allergen.getImageUrl()).isEqualTo(imageUrl);
    assertThat(allergen.getName()).isEqualTo(name);
    assertThat(allergen.getProducts()).isEqualTo(products);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Allergen allergen = new Allergen();
    Category category = new Category();
    List<Allergen> allergens = new ArrayList<>();
    Timestamp timestamp = Timestamp.from(Instant.now());

    Product product = new Product(1L, category, 2.85, 30, "Quesillo",
            "https://assets.elgourmet.com/wp-content/uploads/2023/03/quesi_1GKL9CDFU3guYfZskc6liq8OprHTQx-1024x683.png",
            timestamp, timestamp, allergens);

    //When
    allergen.setId(1L);
    allergen.setImageUrl("https://scu.ugr.es/pages/menu/alergenos/ficheros/Lacteos/!");
    allergen.setName("Lactosa");
    allergen.setProducts(Arrays.asList(product));

    //Then
    assertThat(allergen.getId()).isEqualTo(1L);
    assertThat(allergen.getImageUrl()).isEqualTo("https://scu.ugr.es/pages/menu/alergenos/ficheros/Lacteos/!");
    assertThat(allergen.getName()).isEqualTo("Lactosa");

    // Comprobamos que el producto añadido tiene los valores esperados
    assertThat(allergen.getProducts()).hasSize(1);

    Product retrievedProduct = allergen.getProducts().get(0);
    assertThat(retrievedProduct.getId()).isEqualTo(1L);
    assertThat(retrievedProduct.getName()).isEqualTo("Quesillo");
    assertThat(retrievedProduct.getPrice()).isEqualTo(2.85);
    assertThat(retrievedProduct.getStock()).isEqualTo(30);
    assertThat(retrievedProduct.getImageUrl()).isEqualTo("https://assets.elgourmet.com/wp-content/uploads/2023/03/quesi_1GKL9CDFU3guYfZskc6liq8OprHTQx-1024x683.png");
    assertThat(retrievedProduct.getCreationDate()).isEqualTo(timestamp);
    assertThat(retrievedProduct.getModificationDate()).isEqualTo(timestamp);
  }
}
