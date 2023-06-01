package com.SpringBootApp.mapper;

import com.SpringBootApp.dto.CustomerDto;
import com.SpringBootApp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(source = "id", target = "customerid")
    @Mapping(source = "name", target = "customername")
    CustomerDto CustomerToCustomerDto(Customer customer);
    @Mapping(source = "customerid", target = "id")
    @Mapping(source = "customername", target = "name")
    Customer CustomerDtoToCustomer(CustomerDto customerDto);

}
