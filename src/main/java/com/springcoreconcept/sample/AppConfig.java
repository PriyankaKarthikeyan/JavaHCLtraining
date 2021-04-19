package com.springcoreconcept.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

public class AppConfig {

    @Bean
    //Proxied Scope
    //@Scope(value="prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value="prototype")
    public PrototypeClass prototypeBean() {
        return new PrototypeClass();
    }

    @Bean
    public SingletonClass singletonBean() {
        return new SingletonClass();
    }
}