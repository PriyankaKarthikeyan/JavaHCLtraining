package com.springcoreconcept.sample;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope(value="prototype")
public class PrototypeClass {
   public String dateTimeString = LocalDateTime.now().toString();      

  @Bean
  public String  getTime() {
	  return dateTimeString;
}
}
