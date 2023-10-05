package com.hkjava.pracitce.demopractice;

import org.apache.logging.log4j.util.StringBuilders;

public class hello {
 public static void main(String[] args) {
  
  String address ="1.1.1.1";
  
  System.out.println(address.join("[.]",address.split("\\.")));

  

 } 
}
