package com.SpringBootApp.mapper;

import com.SpringBootApp.dto.CustomerDto;
import com.SpringBootApp.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T14:19:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto CustomerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerid( customer.getId() );
        customerDto.setCustomername( customer.getName() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setAge( customer.getAge() );

        return customerDto;
    }

    @Override
    public Customer CustomerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getCustomerid() );
        customer.setName( customerDto.getCustomername() );
        customer.setEmail( customerDto.getEmail() );
        customer.setAge( customerDto.getAge() );

        return customer;
    }
}
