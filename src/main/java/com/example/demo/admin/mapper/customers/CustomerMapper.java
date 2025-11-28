package com.example.demo.admin.mapper.customers;

import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerDTO.Res> getCustomers(CustomerDTO.Req req);
    Long countCustomers(CustomerDTO.Req req);
}
