package com.miniprojet.service;

import com.miniprojet.entity.Customer;
import com.miniprojet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    public final CustomerRepository customerrespository;

    public CustomerServiceImp(CustomerRepository customerrespository) {
        this.customerrespository = customerrespository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerrespository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerrespository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerrespository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerrespository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerrespository.deleteById(id);
    }
}
