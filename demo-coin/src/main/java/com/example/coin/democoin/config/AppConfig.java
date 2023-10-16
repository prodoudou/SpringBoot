package main.java.com.example.coin.democoin.config;

import java.beans.BeanProperty;

@Configuration
public class AppConfig {
  
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
