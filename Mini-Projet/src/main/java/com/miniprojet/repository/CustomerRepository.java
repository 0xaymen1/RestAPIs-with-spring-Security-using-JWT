package com.miniprojet.repository;

import com.miniprojet.entity.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan("com.miniprojet.CustomerRepository")
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
