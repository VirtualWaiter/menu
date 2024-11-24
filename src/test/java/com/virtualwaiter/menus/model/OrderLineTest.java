package com.virtualwaiter.menus.model;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderLineTest {
  @Test
  void testNoArgsConstructor(){

    //When
    OrderLine orderLine = new OrderLine();

    //Then
    assertThat(orderLine).isNotNull();
    assertThat(orderLine.getId()).isNull();
    assertThat(orderLine.getOrder()).isNull();
    assertThat(orderLine.getProduct()).isNull();
    assertThat(orderLine.getQuantity()).isNull();
    assertThat(orderLine.getUnitPrice()).isNull();
    assertThat(orderLine.getSubtotal()).isNull();
    assertThat(orderLine.getTaxPercentage()).isNull();
    assertThat(orderLine.getTotal()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given
    Long id = 1L;
    Integer quantity = 1;
    Double unitPrice = 30.15;
    Double subtotal = 30.15;
    Double taxPercentage = 7.0;
    Double total = 32.26;
    Timestamp timestamp = Timestamp.from(Instant.now());
    Order order = new Order(1L, new Table(), timestamp, OrderStatus.PENDING, 30.75,
            2.0, 0.60, timestamp, new ArrayList<OrderLine>());

    Product product = new Product(1L, new Category(), 30.75, 80, "Pollo Kung Pao",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2Ao1Q7cHx6sgQVza2ZjxqflcFoBwzM3aLlw&s",
            timestamp, timestamp, new ArrayList<Allergen>());

    //When
    OrderLine orderLine = new OrderLine(id, order, product, quantity, unitPrice, subtotal, taxPercentage, total);

    //Then
    assertThat(orderLine.getId()).isEqualTo(id);
    assertThat(orderLine.getOrder()).isEqualTo(order);
    assertThat(orderLine.getProduct()).isEqualTo(product);
    assertThat(orderLine.getQuantity()).isEqualTo(quantity);
    assertThat(orderLine.getUnitPrice()).isEqualTo(unitPrice);
    assertThat(orderLine.getSubtotal()).isEqualTo(subtotal);
    assertThat(orderLine.getTaxPercentage()).isEqualTo(taxPercentage);
    assertThat(orderLine.getTotal()).isEqualTo(total);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    OrderLine orderLine = new OrderLine();

    Timestamp timestamp = Timestamp.from(Instant.now());

    Order order = new Order(1L, new Table(), timestamp, OrderStatus.PENDING, 30.75,
            2.0, 0.60, timestamp, new ArrayList<OrderLine>());

    Product product = new Product(1L, new Category(), 30.75, 80, "Pollo Kung Pao",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2Ao1Q7cHx6sgQVza2ZjxqflcFoBwzM3aLlw&s",
            timestamp, timestamp, new ArrayList<Allergen>());


    //When
    orderLine.setId(1L);
    orderLine.setOrder(order);
    orderLine.setProduct(product);
    orderLine.setQuantity(1);
    orderLine.setUnitPrice(30.15);
    orderLine.setSubtotal(30.15);
    orderLine.setTaxPercentage(7.0);
    orderLine.setTotal(32.26);

    //Then
    assertThat(orderLine.getId()).isEqualTo(1L);
    assertThat(orderLine.getQuantity()).isEqualTo(1);
    assertThat(orderLine.getUnitPrice()).isEqualTo(30.15);
    assertThat(orderLine.getSubtotal()).isEqualTo(30.15);
    assertThat(orderLine.getTaxPercentage()).isEqualTo(7.0);
    assertThat(orderLine.getTotal()).isEqualTo(32.26);


    // Comprobamos que la order añadida tiene los valores esperados
    Order retrievedOrder = orderLine.getOrder();
    assertThat(retrievedOrder.getId()).isEqualTo(1L);
    assertThat(retrievedOrder.getOrderDate()).isEqualTo(timestamp);
    assertThat(retrievedOrder.getStatus()).isEqualTo(OrderStatus.PENDING);
    assertThat(retrievedOrder.getTotalAmount()).isEqualTo(30.75);
    assertThat(retrievedOrder.getCommisionPercentage()).isEqualTo(2.0);
    assertThat(retrievedOrder.getTotalCommision()).isEqualTo(0.62);
    assertThat(retrievedOrder.getModifiedDate()).isEqualTo(timestamp);

    // Comprobamos que el product añadido tiene los valores esperados
    Product retrievedProduct = orderLine.getProduct();
    assertThat(retrievedProduct.getId()).isEqualTo(1L);
    assertThat(retrievedProduct.getPrice()).isEqualTo(30.75);
    assertThat(retrievedProduct.getStock()).isEqualTo(80);
    assertThat(retrievedProduct.getName()).isEqualTo("Pollo Kung Pao");
    assertThat(retrievedProduct.getImageUrl()).isEqualTo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2Ao1Q7cHx6sgQVza2ZjxqflcFoBwzM3aLlw&s");
    assertThat(retrievedProduct.getCreationDate()).isEqualTo(timestamp);
    assertThat(retrievedProduct.getModificationDate()).isEqualTo(timestamp);


  }
}
