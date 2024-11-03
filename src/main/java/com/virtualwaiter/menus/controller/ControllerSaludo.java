package com.virtualwaiter.menus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/saludo")
public class ControllerSaludo {

  @GetMapping("/hola-mundo")
  public String retrieveSaludo(){
    return "Hola mundo!";
  }

  @GetMapping("/adios-mundo")
  public String retrieveDespedida(){
    return "Adios mundo!!";
  }

}
