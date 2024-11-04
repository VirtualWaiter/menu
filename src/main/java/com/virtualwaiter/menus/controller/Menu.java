package com.virtualwaiter.menus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/menu")
public class Menu {

  @GetMapping("/1")
  public List<String> retrieveDespedida(){
    List<String> menu = Arrays.asList("Fanta, Cocacola");
    return menu;
  }
}
