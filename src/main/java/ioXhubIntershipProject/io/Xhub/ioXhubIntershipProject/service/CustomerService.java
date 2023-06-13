package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.service;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.dto.CustomerDto;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.entity.Customer;
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
