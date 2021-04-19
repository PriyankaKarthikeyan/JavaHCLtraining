package com.springcoreconcept.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
		SingletonClass sg= new SingletonClass();
		sg.showTimemessage();      
		sg.showTimemessage();
	}

}
