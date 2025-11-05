package com.example.demo.mapper.customers;

import com.example.demo.dto.customerDTO.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerDTO> findAll();
}
