package com.hkjava.demo.demoredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demoredis.service.CompanyServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class RedisController {
  
  @Autowired
  private CompanyServiceImpl companyServiceImpl;
  
  @GetMapping("/redis/set")
  public void set() {
    companyServiceImpl.set();
  }

  @GetMapping("/redis/get")
  public void get() {
    companyServiceImpl.get();
  }
  
}
