package com.ProjectSpringBoot.service;

import com.ProjectSpringBoot.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
List<Customer> findAllCustomer();
Optional<Customer> findById(Integer id);

Customer saveCustomer(Customer customer);
Customer updateCustomer(Customer customer);
void deleteCustomer(Integer id);

}
