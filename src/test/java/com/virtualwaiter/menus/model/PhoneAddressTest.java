package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneAddressTest {
  @Test
  void testNoArgsConstructor(){

    //When
    PhoneAddress phoneAddress = new PhoneAddress();

    //Then
    assertThat(phoneAddress).isNotNull();
    assertThat(phoneAddress.getId()).isNull();
    assertThat(phoneAddress.getExternalNumber()).isNull();
    assertThat(phoneAddress.getPhoneNumber()).isNull();
    assertThat(phoneAddress.getMcrestaurant()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    String externalNumber = "+34";
    String phoneNumber = "647025041";
    String mcRestaurant = "1";

    //When
    PhoneAddress phoneAddress = new PhoneAddress(id, externalNumber, phoneNumber, mcRestaurant);

    //Then
    assertThat(phoneAddress.getId()).isEqualTo(id);
    assertThat(phoneAddress.getExternalNumber()).isEqualTo(externalNumber);
    assertThat(phoneAddress.getPhoneNumber()).isEqualTo(phoneNumber);
    assertThat(phoneAddress.getMcrestaurant()).isEqualTo(mcRestaurant);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    PhoneAddress phoneAddress = new PhoneAddress();

    //When
    phoneAddress.setId(1L);
    phoneAddress.setExternalNumber("+34");
    phoneAddress.setPhoneNumber("647025041");
    phoneAddress.setMcrestaurant("1");

    //Then
    assertThat(phoneAddress.getId()).isEqualTo(1L);
    assertThat(phoneAddress.getExternalNumber()).isEqualTo("+34");
    assertThat(phoneAddress.getPhoneNumber()).isEqualTo("647025041");
    assertThat(phoneAddress.getMcrestaurant()).isEqualTo("1");
  }
}
