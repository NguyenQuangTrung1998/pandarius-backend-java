package com.example.demo.admin.services.customers.impl;

import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import com.example.demo.admin.mapper.customers.CustomerMapper;
import com.example.demo.admin.services.customers.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersImpl implements CustomersService {
    private final CustomerMapper customerMapper;
    @Override
    public List<CustomerDTO> getCustomers(){
        return customerMapper.findAll();
    }
}
