package com.example.demo.admin.services.customers;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomersService {
    PagedResult<CustomerDTO.Res> getCustomers(CustomerDTO.Req req);
    void addCustomer(CustomerDTO.Body body);
    void deleteCustomer(String id);
    CustomerDTO.Res findCustomerById(String id);
}
