package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

  @Test
  void testNoArgsConstructor(){

    //When
    Address address = new Address();

    //Then
    assertThat(address).isNotNull();

    assertThat(address.getId()).isNull();
    assertThat(address.getCountry()).isNull();
    assertThat(address.getZipCode()).isNull();
    assertThat(address.getAddress()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    String country = "Spain";
    String zipCode = "38320";
    String postalAddress = "Carretera Entrada Valle Tabares, 110";

    //When
    Address address = new Address(id, country, postalAddress, zipCode);

    //Then
    assertThat(address.getId()).isEqualTo(id);
    assertThat(address.getCountry()).isEqualTo(country);
    assertThat(address.getZipCode()).isEqualTo(zipCode);
    assertThat(address.getAddress()).isEqualTo(postalAddress);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Address address = new Address();

    //When
    address.setId(1L);
    address.setCountry("Spain");
    address.setAddress("Carretera Entrada Valle Tabares, 110");
    address.setZipCode("38320");

    //Then
    assertThat(address.getId()).isEqualTo(1L);
    assertThat(address.getCountry()).isEqualTo("Spain");
    assertThat(address.getZipCode()).isEqualTo("38320");
    assertThat(address.getAddress()).isEqualTo("Carretera Entrada Valle Tabares, 110");
  }
}
