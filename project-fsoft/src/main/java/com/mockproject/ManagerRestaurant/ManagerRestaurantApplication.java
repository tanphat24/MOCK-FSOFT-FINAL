package com.mockproject.ManagerRestaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ManagerRestaurantApplication {

	@Autowired
	
	public static void main(String[] args) {
		SpringApplication.run(ManagerRestaurantApplication.class, args);
		
		
	}


}
