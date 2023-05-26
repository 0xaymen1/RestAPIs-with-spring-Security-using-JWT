package com.miniprojet.controller;

import com.miniprojet.entity.Customer;
import com.miniprojet.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Customer")
   public class CustomerController {
   private final CustomerService customerservice;

   public CustomerController(CustomerService customerservice) {
      this.customerservice = customerservice;
   }
   @GetMapping
   public List<Customer> getCustomers(){
      return customerservice.findAllCustomer();
   }


   }

