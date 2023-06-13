package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.service;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.dto.CustomerDto;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.entity.Customer;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.mapper.CustomerMapper;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDto> findAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDto> findById(Integer id) {
        return customerRepository.findById(id)
                .map(this::convertEntityToDto);
    }


    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = convertDtoToEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return convertEntityToDto(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer = convertDtoToEntity(customerDto);
        Customer updatedCustomer = customerRepository.save(customer);
        return convertEntityToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto convertEntityToDto(Customer customer) {
        return customerMapper.CustomerToCustomerDto(customer);
    }

    @Override
    public Customer convertDtoToEntity(CustomerDto customerDto) {
        return customerMapper.CustomerDtoToCustomer(customerDto);
    }
}
