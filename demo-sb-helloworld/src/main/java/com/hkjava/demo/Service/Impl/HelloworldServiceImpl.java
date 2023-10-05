package com.hkjava.demo.Service.Impl;
import org.springframework.stereotype.Service;

import com.hkjava.demo.Service.HelloworldService;

@Service //<---------------------
public class HelloworldServiceImpl implements HelloworldService{
  @Override
  public String generate(int x){
    if(x > 100)
    return "hello world";
    return "ABC";

  }
}
