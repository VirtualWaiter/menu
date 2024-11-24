package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantOwnerTest {
  @Test
  void testNoArgsConstructor(){

    //When
    RestaurantOwner restaurantOwner = new RestaurantOwner();

    //Then
    assertThat(restaurantOwner).isNotNull();
    assertThat(restaurantOwner.getId()).isNull();
    assertThat(restaurantOwner.getPhoneAddress()).isNull();
    assertThat(restaurantOwner.getName()).isNull();
    assertThat(restaurantOwner.getEmail()).isNull();
    assertThat(restaurantOwner.getIdNumber()).isNull();
    assertThat(restaurantOwner.getBankAccountNumber()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    String name = "Samuel";
    String email = "samuelfumerohdez@gmail.com";
    String idNumber = "12345678Z";
    String bankAccountNumber = "ES3584202563952485";

    PhoneAddress phoneAddress = new PhoneAddress(1L, "+34", "666666666", "1");

    //When
    RestaurantOwner restaurantOwner = new RestaurantOwner(id, phoneAddress, name, email, idNumber, bankAccountNumber);

    //Then
    assertThat(restaurantOwner.getId()).isEqualTo(id);
    assertThat(restaurantOwner.getPhoneAddress()).isEqualTo(phoneAddress);
    assertThat(restaurantOwner.getName()).isEqualTo(name);
    assertThat(restaurantOwner.getEmail()).isEqualTo(email);
    assertThat(restaurantOwner.getIdNumber()).isEqualTo(idNumber);
    assertThat(restaurantOwner.getBankAccountNumber()).isEqualTo(bankAccountNumber);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    RestaurantOwner restaurantOwner = new RestaurantOwner();

    PhoneAddress phoneAddress = new PhoneAddress(1L, "+34", "666666666", "1");

    //When
    restaurantOwner.setId(1L);
    restaurantOwner.setPhoneAddress(phoneAddress);
    restaurantOwner.setName("Samuel");
    restaurantOwner.setEmail("samuelfumerohdez@gmail.com");
    restaurantOwner.setIdNumber("12345678Z");
    restaurantOwner.setBankAccountNumber("ES3584202563952485");

    //Then
    assertThat(restaurantOwner.getId()).isEqualTo(1L);
    assertThat(restaurantOwner.getName()).isEqualTo("Samuel");
    assertThat(restaurantOwner.getEmail()).isEqualTo("samuelfumerohdez@gmail.com");
    assertThat(restaurantOwner.getIdNumber()).isEqualTo("12345678Z");
    assertThat(restaurantOwner.getBankAccountNumber()).isEqualTo("ES3584202563952485");

    // Comprobamos que el phoneAddress añadido tiene los valores esperados
    PhoneAddress retrievedPhoneAddress = restaurantOwner.getPhoneAddress();
    assertThat(retrievedPhoneAddress.getId()).isEqualTo(1L);
    assertThat(retrievedPhoneAddress.getExternalNumber()).isEqualTo("+34");
    assertThat(retrievedPhoneAddress.getPhoneNumber()).isEqualTo("666666666");
    assertThat(retrievedPhoneAddress.getMcrestaurant()).isEqualTo("1");
  }
}
