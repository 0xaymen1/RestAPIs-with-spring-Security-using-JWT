package com.SpringBootApp.controller;

import com.SpringBootApp.dto.CustomerDto;
import com.SpringBootApp.entity.Customer;
import com.SpringBootApp.mapper.CustomerMapper;
import com.SpringBootApp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
   public class CustomerController {
   private final CustomerService customerservice;


   public CustomerController(CustomerService customerservice) {
      this.customerservice = customerservice;
   }

   @GetMapping
   public List<CustomerDto> findAllCustomer() {
      return customerservice.findAllCustomer();
   }
   @GetMapping("/{id}")
   public Optional<CustomerDto> findById(@PathVariable("id") Integer id) {
      return customerservice.findById(id);
}
   @RequestMapping("/add")
   public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
      return customerservice.saveCustomer(customerDto);}
   @PutMapping("/edit")
   public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto){
      return customerservice.saveCustomer(customerDto);}
   @DeleteMapping("/{id}")
   public void deleteCustomer(@PathVariable("id") Integer id){
      customerservice.deleteCustomer(id);
   }


   }

