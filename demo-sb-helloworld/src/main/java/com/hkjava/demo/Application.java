package com.hkjava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//SpringbootApplication等於下面個三個

//@configuration
//@enableautoconfiguration
//@ComponentScan (Most important) 

// ComponentScan is to scan @Controller, @serivce , @repository, @configuration.
//if yes, create an object of those classes and put that object into SpringContext
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
