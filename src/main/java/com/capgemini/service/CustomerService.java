package com.capgemini.service;

import com.capgemini.exception.InvalidQuery;
import com.capgemini.model.Customer;
import com.capgemini.repository.RepositoryInterface;
import com.capgemini.service.dto.CustomerDTO;
import com.capgemini.service.mapper.CustomerMapper;
import org.tinylog.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    RepositoryInterface<Customer> customerRepositoryInterface;

    public CustomerService(RepositoryInterface<Customer> customerRepositoryInterface) {
        this.customerRepositoryInterface = customerRepositoryInterface;
    }

    public void insertOneCustomer() throws InvalidQuery{
        customerRepositoryInterface.insertRow();
    }

    public void deleteOneCustomerByCustomerId(String customerNumber) throws InvalidQuery {
        customerRepositoryInterface.deleteRow(customerNumber);
    }

    public void updatePhoneCustomerByCity(String city) throws InvalidQuery {
        customerRepositoryInterface.updateRow(city);
    }

    public List<CustomerDTO> showAllCustomers() throws InvalidQuery {
        try {
            return customerRepositoryInterface.readFromDatabase().stream().map(CustomerMapper::fromCustomerToProductDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }
}
