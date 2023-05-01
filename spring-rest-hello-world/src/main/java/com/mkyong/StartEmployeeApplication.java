package com.mkyong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class StartEmployeeApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartEmployeeApplication.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Swarna", "Mohanty",12345678910L, "add@gmail.com"));
            repository.save(new Employee("Gyana", "Mohanty",  123458383910L, "add@gmail.com"));
        };
    }
}