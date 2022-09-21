package com.avg.poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private EmployeeCrudRepository repository;// a repository is a service (also).

    @Autowired
    private PropertyPoC propertyPoC;

    @Bean
    public CommandLineRunner run(EmployeeCrudRepository repository) {
        return (args -> {
            // populateEmployee(repository);
            System.out.println(repository.findAll());
            System.out.println(propertyPoC.toString());
        });
    }

    private void populateEmployee(EmployeeCrudRepository repository) {
        repository.save(new Employee("Alejandro"));
        repository.save(new Employee("Maria"));
        repository.save(new Employee("Diego"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
