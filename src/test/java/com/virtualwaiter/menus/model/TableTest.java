package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Table table = new Table();

    //Then
    assertThat(table).isNotNull();
    assertThat(table.getId()).isNull();
    assertThat(table.getRestaurant()).isNull();
    assertThat(table.getTableNumber()).isNull();
    assertThat(table.getQrcode()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    Integer tableNumber = 10;
    String qrcode = "https://virtualwaiter.com/tables/10";
    Restaurant restaurant = new Restaurant(1L, new PhoneAddress(), new Address(), new RestaurantOwner(), "Villabajo",
            "villabajo@gmail.com", Status.ACTIVO, "12345678Z", new ArrayList<Table>());


    //When
    Table table = new Table(id, restaurant, tableNumber, qrcode);

    //Then
    assertThat(table.getId()).isEqualTo(id);
    assertThat(table.getRestaurant()).isEqualTo(restaurant);
    assertThat(table.getTableNumber()).isEqualTo(10);
    assertThat(table.getQrcode()).isEqualTo("https://virtualwaiter.com/tables/10");
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Table table = new Table();

    Restaurant restaurant = new Restaurant(1L, new PhoneAddress(), new Address(), new RestaurantOwner(), "Villabajo",
            "villabajo@gmail.com", Status.ACTIVO, "12345678Z", new ArrayList<Table>());

    //When
    table.setId(1L);
    table.setRestaurant(restaurant);
    table.setTableNumber(10);
    table.setQrcode("https://virtualwaiter.com/tables/10");

    //Then
    assertThat(table.getId()).isEqualTo(1L);
    assertThat(table.getTableNumber()).isEqualTo(10);
    assertThat(table.getQrcode()).isEqualTo("https://virtualwaiter.com/tables/10");

    // Comprobamos que el restaurante añadido tiene los valores esperados
    Restaurant retrievedRestaurant = table.getRestaurant();
    assertThat(retrievedRestaurant.getId()).isEqualTo(1L);
    assertThat(retrievedRestaurant.getName()).isEqualTo("Villabajo");
    assertThat(retrievedRestaurant.getEmail()).isEqualTo("villabajo@gmail.com");
    assertThat(retrievedRestaurant.getStatus()).isEqualTo(Status.ACTIVO);
    assertThat(retrievedRestaurant.getCif()).isEqualTo("12345678Z");


  }
}
