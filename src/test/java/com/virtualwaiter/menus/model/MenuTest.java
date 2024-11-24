package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Menu menu = new Menu();

    //Then
    assertThat(menu).isNotNull();
    assertThat(menu.getId()).isNull();
    assertThat(menu.getRestaurant()).isNull();
    assertThat(menu.getCategories()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    Restaurant restaurant = new Restaurant(1L, new PhoneAddress(), new Address(), new RestaurantOwner(), "Villabajo",
            "villabajo@gmail.com", Status.ACTIVO, "12345678Z", new ArrayList<Table>());

    List<Category> categories = Arrays.asList(new Category(1L, "Entrantes", new ArrayList<Product>(), new Menu()));

    //When
    Menu menu = new Menu(id, restaurant, categories);

    //Then
    assertThat(menu.getId()).isEqualTo(id);
    assertThat(menu.getRestaurant()).isEqualTo(restaurant);
    assertThat(menu.getCategories()).isEqualTo(categories);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Menu menu = new Menu();

    Restaurant restaurant = new Restaurant(1L, new PhoneAddress(), new Address(), new RestaurantOwner(), "Villabajo",
            "villabajo@gmail.com", Status.ACTIVO, "12345678Z", new ArrayList<Table>());

    List<Category> categories = Arrays.asList(new Category(1L, "Entrantes", new ArrayList<Product>(), new Menu()));

    //When
    menu.setId(1L);
    menu.setRestaurant(restaurant);
    menu.setCategories(categories);

    //Then
    assertThat(menu.getId()).isEqualTo(1L);

    // Comprobamos que el restaurante añadido tiene los valores esperados
    Restaurant retrievedRestaurant = menu.getRestaurant();
    assertThat(retrievedRestaurant.getId()).isEqualTo(1L);
    assertThat(retrievedRestaurant.getName()).isEqualTo("Villabajo");
    assertThat(retrievedRestaurant.getEmail()).isEqualTo("villabajo@gmail.com");
    assertThat(retrievedRestaurant.getStatus()).isEqualTo(Status.ACTIVO);
    assertThat(retrievedRestaurant.getCif()).isEqualTo("12345678Z");

    // Comprobamos que la lista de categorias añadida tiene los valores esperados
    assertThat(menu.getCategories()).hasSize(1);

    Category retrievedCategory = menu.getCategories().get(0);
    assertThat(retrievedCategory.getId()).isEqualTo(1L);
    assertThat(retrievedCategory.getName()).isEqualTo("Entrantes");

  }
}
