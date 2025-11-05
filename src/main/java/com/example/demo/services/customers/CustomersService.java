package com.example.demo.services.customers;

import com.example.demo.dto.customerDTO.CustomerDTO;
import java.util.List;

public interface CustomersService {
    List<CustomerDTO> getCustomers();
}
