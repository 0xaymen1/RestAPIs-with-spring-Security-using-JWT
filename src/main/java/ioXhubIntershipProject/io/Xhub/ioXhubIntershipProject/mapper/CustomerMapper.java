package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.mapper;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.dto.CustomerDto;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.entity.Customer;
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
