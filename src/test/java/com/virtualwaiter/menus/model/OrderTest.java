package com.virtualwaiter.menus.model;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
  @Test
  void testNoArgsConstructor(){

    //When
    Order order = new Order();

    //Then
    assertThat(order).isNotNull();
    assertThat(order.getId()).isNull();
    assertThat(order.getTable()).isNull();
    assertThat(order.getOrderDate()).isNull();
    assertThat(order.getStatus()).isNull();
    assertThat(order.getTotalAmount()).isNull();
    assertThat(order.getCommisionPercentage()).isNull();
    assertThat(order.getModifiedDate()).isNull();
    assertThat(order.getOrderLines()).isNull();
  }

  @Test
  void testAllArgsConstructor(){

    //Given

    Long id = 1L;
    Timestamp timestamp = Timestamp.from(Instant.now());
    OrderStatus orderStatus = OrderStatus.IN_PROGRESS;
    Double totalAmount = 2.85;
    Double commisionPercentage = 2.0;
    Double totalComision = 0.06;
    Timestamp orderDate = timestamp;
    Timestamp modifiedDate = timestamp;

    Table table = new Table(1L, new Restaurant(), 10, "https://virtualwaiter.com/tables/10");
    List<OrderLine> orderLines = Arrays.asList(new OrderLine(1L, new Order(), new Product(), 1, 2.65,
            2.65, 7.0, 2.85));

    //When
    Order order = new Order(id, table, orderDate, orderStatus, totalAmount, commisionPercentage, totalComision,
            modifiedDate, orderLines);

    //Then
    assertThat(order.getId()).isEqualTo(id);
    assertThat(order.getTable()).isEqualTo(table);
    assertThat(order.getOrderDate()).isEqualTo(orderDate);
    assertThat(order.getStatus()).isEqualTo(orderStatus);
    assertThat(order.getTotalAmount()).isEqualTo(totalAmount);
    assertThat(order.getCommisionPercentage()).isEqualTo(commisionPercentage);
    assertThat(order.getTotalCommision()).isEqualTo(totalComision);
    assertThat(order.getModifiedDate()).isEqualTo(modifiedDate);
    assertThat(order.getOrderLines()).isEqualTo(orderLines);
  }

  @Test
  void testSettersAndGetters(){
    //Given
    Order order = new Order();
    Timestamp timestamp = Timestamp.from(Instant.now());

    Table table = new Table(1L, new Restaurant(), 10, "https://virtualwaiter.com/tables/10");
    List<OrderLine> orderLines = Arrays.asList(new OrderLine(1L, new Order(), new Product(), 1, 2.65,
            2.65, 7.0, 2.85));


    //When
    order.setId(1L);
    order.setTable(table);
    order.setOrderDate(timestamp);
    order.setStatus(OrderStatus.IN_PROGRESS);
    order.setTotalAmount(2.85);
    order.setCommisionPercentage(2.0);
    order.setTotalCommision(0.06);
    order.setModifiedDate(timestamp);
    order.setOrderLines(orderLines);

    //Then
    assertThat(order.getId()).isEqualTo(1L);
    assertThat(order.getOrderDate()).isEqualTo(timestamp);
    assertThat(order.getStatus()).isEqualTo(OrderStatus.IN_PROGRESS);
    assertThat(order.getTotalAmount()).isEqualTo(2.85);
    assertThat(order.getCommisionPercentage()).isEqualTo(2.0);
    assertThat(order.getTotalCommision()).isEqualTo(0.06);
    assertThat(order.getModifiedDate()).isEqualTo(timestamp);

    // Comprobamos que el la orderLine añadida tiene los valores esperados
    assertThat(order.getOrderLines()).hasSize(1);

    OrderLine retrievedOrderLine = order.getOrderLines().get(0);
    assertThat(retrievedOrderLine.getId()).isEqualTo(1L);
    assertThat(retrievedOrderLine.getQuantity()).isEqualTo(1);
    assertThat(retrievedOrderLine.getUnitPrice()).isEqualTo(2.65);
    assertThat(retrievedOrderLine.getSubtotal()).isEqualTo(2.65);
    assertThat(retrievedOrderLine.getTaxPercentage()).isEqualTo(7.0);
    assertThat(retrievedOrderLine.getTotal()).isEqualTo(2.85);

    //Comprobamos que el Table añadido tiene los valores esperados
    Table retrievedTable = order.getTable();
    assertThat(retrievedTable.getId()).isEqualTo(1L);
    assertThat(retrievedTable.getTableNumber()).isEqualTo(10);
    assertThat(retrievedTable.getQrcode()).isEqualTo("https://virtualwaiter.com/tables/10");
  }
}
