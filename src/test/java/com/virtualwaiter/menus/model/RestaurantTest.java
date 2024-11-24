package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Restaurant restaurant = new Restaurant();

    //Then
    assertThat(restaurant).isNotNull();
    assertThat(restaurant.getId()).isNull();
    assertThat(restaurant.getPhoneAddress()).isNull();
    assertThat(restaurant.getName()).isNull();
    assertThat(restaurant.getEmail()).isNull();
    assertThat(restaurant.getRestaurantOwner()).isNull();
    assertThat(restaurant.getAddress()).isNull();
    assertThat(restaurant.getStatus()).isNull();
    assertThat(restaurant.getCif()).isNull();
    assertThat(restaurant.getTables()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    String name = "Villabajo";
    String email = "samuelfumerohdez@gmail.com";
    Status status = Status.ACTIVO;
    String cif = "12345678Z";

    PhoneAddress phoneAddress = new PhoneAddress(1L, "+34", "666666666", "1");

    Address address = new Address(1L, "Spain", "Carretera Entrada Valle Tabares 110", "38320");

    RestaurantOwner restaurantOwner = new RestaurantOwner(1L, new PhoneAddress(), "Samuel",
            "samuelfumerohdez@gmail.com", "12345678Z", "ES3584202563952485");

    List<Table> tables = Arrays.asList(new Table(1L, new Restaurant(), 10,
            "https://virtualwaiter.com/tables/10"));

    //When
    Restaurant restaurant = new Restaurant(id, phoneAddress, address, restaurantOwner, name, email, status, cif, tables);


    //Then
    assertThat(restaurant.getId()).isEqualTo(id);
    assertThat(restaurant.getPhoneAddress()).isEqualTo(phoneAddress);
    assertThat(restaurant.getAddress()).isEqualTo(address);
    assertThat(restaurant.getRestaurantOwner()).isEqualTo(restaurantOwner);
    assertThat(restaurant.getName()).isEqualTo(name);
    assertThat(restaurant.getEmail()).isEqualTo(email);
    assertThat(restaurant.getStatus()).isEqualTo(status);
    assertThat(restaurant.getCif()).isEqualTo(cif);
    assertThat(restaurant.getTables()).isEqualTo(tables);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Restaurant restaurant = new Restaurant();

    PhoneAddress phoneAddress = new PhoneAddress(1L, "+34", "666666666", "1");

    Address address = new Address(1L, "Spain", "Carretera Entrada Valle Tabares 110", "38320");

    RestaurantOwner restaurantOwner = new RestaurantOwner(1L, new PhoneAddress(), "Samuel",
            "samuelfumerohdez@gmail.com", "12345678Z", "ES3584202563952485");

    List<Table> tables = Arrays.asList(new Table(1L, new Restaurant(), 10,
            "https://virtualwaiter.com/tables/10"));

    //When
    restaurant.setId(1L);
    restaurant.setPhoneAddress(phoneAddress);
    restaurant.setAddress(address);
    restaurant.setRestaurantOwner(restaurantOwner);
    restaurant.setTables(tables);
    restaurant.setName("Villabajo");
    restaurant.setEmail("samuelfumerohdez@gmail.com");
    restaurant.setCif("12345678Z");
    restaurant.setStatus(Status.ACTIVO);

    //Then
    assertThat(restaurant.getId()).isEqualTo(1L);
    assertThat(restaurant.getName()).isEqualTo("Villabajo");
    assertThat(restaurant.getEmail()).isEqualTo("samuelfumerohdez@gmail.com");
    assertThat(restaurant.getStatus()).isEqualTo(Status.ACTIVO);
    assertThat(restaurant.getCif()).isEqualTo("12345678Z");

    // Comprobamos que el phoneAddress añadido tiene los valores esperados
    PhoneAddress retrievedPhoneAddress = restaurant.getPhoneAddress();
    assertThat(retrievedPhoneAddress.getId()).isEqualTo(1L);
    assertThat(retrievedPhoneAddress.getExternalNumber()).isEqualTo("+34");
    assertThat(retrievedPhoneAddress.getPhoneNumber()).isEqualTo("666666666");
    assertThat(retrievedPhoneAddress.getMcrestaurant()).isEqualTo("1");

    // Comprobamos que el address añadido tiene los valores esperados
    Address retrievedAddress = restaurant.getAddress();
    assertThat(retrievedAddress.getId()).isEqualTo(1L);
    assertThat(retrievedAddress.getCountry()).isEqualTo("Spain");
    assertThat(retrievedAddress.getAddress()).isEqualTo("Carretera Entrada Valle Tabares 110");
    assertThat(retrievedAddress.getZipCode()).isEqualTo("38320");

    // Comprobamos que el restaurantOwner añadido tiene los valores esperados
    RestaurantOwner retrievedRestaurantOwner = restaurant.getRestaurantOwner();
    assertThat(retrievedRestaurantOwner.getId()).isEqualTo(1L);
    assertThat(retrievedRestaurantOwner.getName()).isEqualTo("Samuel");
    assertThat(retrievedRestaurantOwner.getEmail()).isEqualTo("samuelfumerohdez@gmail.com");
    assertThat(retrievedRestaurantOwner.getIdNumber()).isEqualTo("12345678Z");
    assertThat(retrievedRestaurantOwner.getBankAccountNumber()).isEqualTo("ES3584202563952485");

    //Comprobamos que el table añadido tiene los valores esperados
    assertThat(restaurant.getTables()).hasSize(1);

    Table table = restaurant.getTables().get(0);
    assertThat(table.getId()).isEqualTo(1L);
    assertThat(table.getTableNumber()).isEqualTo(10);
    assertThat(table.getQrcode()).isEqualTo("https://virtualwaiter.com/tables/10");
  }
}
