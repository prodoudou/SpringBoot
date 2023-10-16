package com.example.hello.halo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class Halocontroller {
  
  @GetMapping(value = "/halo")
  public String sayHalo(String halo){
    return "halo";
  }
}
