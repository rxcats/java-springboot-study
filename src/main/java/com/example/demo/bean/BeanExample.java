package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
public class BeanExample {

    @Bean(name = "apple1")
    public Apple apple() {
        return new Apple();
    }

    @Bean(name = "apple2")
    public Apple apple2() {
        return new Apple();
    }

    @Bean
    public Banana banana() {
        return new Banana();
    }

    @Bean
    public AnimalService animalService() {
        return new AnimalService();
    }

    // type 기반 : default
    // name 기반

    // ApplicationContext interface

    static class Apple {

    }

    static class Banana {

    }

}
