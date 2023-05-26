package com.miniprojet.controller;

import com.miniprojet.entity.Customer;
import com.miniprojet.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
   @GetMapping("/{id}")
   public Optional<Customer> findById(@PathVariable("id") Integer id) {
   return customerservice.findById(id);
}
   @PostMapping
   public Customer saveCustomer(@RequestBody Customer customer){
      return customerservice.saveCustomer(customer);}
   @PutMapping
   public Customer updateCustomer(@RequestBody Customer customer){
      return customerservice.saveCustomer(customer);}
   @DeleteMapping("/{id}")
   public void deleteCustomer(@PathVariable("id") Integer id){
      customerservice.deleteCustomer(id);
   }


   }

