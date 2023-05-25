package com.miniprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
@RequestMapping("api/v1/cstomers")

public class Main {
    private final CustomersRepository CustomersRepository;

    public Main(CustomersRepository customersRepository) {
        this.CustomersRepository = customersRepository;
    }
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customers> getCustomers(){
        return CustomersRepository.findAll();
    }

    @PostMapping
    public void addCustomers(@RequestBody NewCustomersRequest request) {
        Customers customer = new Customers();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        CustomersRepository.save(customer);
    }

}