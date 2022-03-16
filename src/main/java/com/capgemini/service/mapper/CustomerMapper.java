package com.capgemini.service.mapper;

import com.capgemini.model.Customer;
import com.capgemini.service.dto.CustomerDTO;

public class CustomerMapper {
    public static CustomerDTO fromCustomerToProductDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerNumber(customer.getCustomerNumber());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setContactLastName(customer.getContactLastName());
        customerDTO.setContactFirstName(customer.getContactFirstName());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setCity(customer.getCity());
        return customerDTO;
    }
}
