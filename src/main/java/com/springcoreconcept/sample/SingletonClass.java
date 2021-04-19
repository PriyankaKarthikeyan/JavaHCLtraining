package com.springcoreconcept.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonClass {
	
	@Autowired
	public PrototypeClass protoobj;
	
	@Bean
	public void showTimemessage() {
		protoobj= new PrototypeClass();
        System.out.println("The prototype bean version is " + protoobj.getTime());
	}
	
	@Lookup       
    public PrototypeClass getPrototypeBean() {
        //Do not provide method implementation, spring will override this method behind the scenes.
       return null;
    }

}
