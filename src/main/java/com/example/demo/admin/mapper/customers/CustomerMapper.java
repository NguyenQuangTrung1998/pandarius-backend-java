package com.example.demo.admin.mapper.customers;

import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerDTO.Res> getCustomers(CustomerDTO.Req req);
    Long countCustomers(CustomerDTO.Req req);
    void addCustomer(CustomerDTO.Body body);
    void deleteCustomer(@Param("id") String id);
    CustomerDTO.Res findCustomerById(@Param("id") String id );
    List<CustomerDTO.Res> findAll();

}
