package com.SpringBootApp.service;

import com.SpringBootApp.dto.CustomerDto;
import com.SpringBootApp.entity.Customer;
import com.SpringBootApp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public interface CustomerService {


    List<CustomerDto> findAllCustomer();
Optional<CustomerDto> findById(Integer id);

CustomerDto saveCustomer(CustomerDto customerDto);
CustomerDto updateCustomer(CustomerDto customerDto);
void deleteCustomer(Integer id);


    CustomerDto convertEntityToDto(Customer customer);

    Customer convertDtoToEntity(CustomerDto customerDto);

}
