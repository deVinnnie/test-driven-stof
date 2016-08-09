package com.realdolmen.stof;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.realdolmen.stof"})
@EntityScan(basePackages = {"com.realdolmen.stof"})
@EnableJpaRepositories
@SpringBootApplication
public class Application {


    public static void main(String [] args){
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
}
