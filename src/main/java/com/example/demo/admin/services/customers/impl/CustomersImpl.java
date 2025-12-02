package com.example.demo.admin.services.customers.impl;
import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import com.example.demo.admin.mapper.customers.CustomerMapper;
import com.example.demo.admin.services.customers.CustomersService;
import com.example.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomersImpl implements CustomersService {
    private final CustomerMapper customerMapper;
    @Override
    public PagedResult<CustomerDTO.Res> getCustomers(CustomerDTO.Req req){
        // Lấy danh sách sản phẩm theo điều kiện + limit/offset
        List<CustomerDTO.Res> items = customerMapper.getCustomers(req);
        // Lấy tổng số bản ghi để phân trang
        Long totalCount = customerMapper.countCustomers(req);
        // Wrap vào PagedResult
        PagedResult<CustomerDTO.Res> result = new PagedResult<>();
        result.setItems(items);
        result.setTotalCount(totalCount);
        return result;
    }

    @Override
    public void addCustomer(CustomerDTO.Body body) {
      customerMapper.addCustomer(body);
    }

    @Override
    public void deleteCustomer(String id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    public CustomerDTO.Res findCustomerById(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Thông tin không hợp lệ, vui lòng kiểm tra lại!");
        }else {
            CustomerDTO.Res customer = customerMapper.findCustomerById(id);
            if(customer==null){
                throw new ResourceNotFoundException("Không tìm thấy khách hàng với id = " + id);
            }
            return customer;
        }

    }

}
