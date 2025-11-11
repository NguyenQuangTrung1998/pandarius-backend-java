package com.example.demo.admin.services.customers;

import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import java.util.List;

public interface CustomersService {
    List<CustomerDTO> getCustomers();
}
