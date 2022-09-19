package com.avg.poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    EmployeeRepository repository;// a repository is a service (also).

    @GetMapping("/hello")
    public String getMessage(){
        return "Hello world spring-boot!! " + repository.findEmployeeByNameContaining("Ale");
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository){
        return (args -> {
           populateEmployee(repository);
           System.out.println(repository.findAll());
        });
    }

    private void populateEmployee(EmployeeRepository repository) {
        repository.save(new Employee("Alejandro"));
        repository.save(new Employee("Maria"));
        repository.save(new Employee("Diego"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
