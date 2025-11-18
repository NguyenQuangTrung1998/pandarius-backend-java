package com.example.demo.admin.mapper.orders;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.orderDTO.OrderDTO;
import com.example.demo.admin.dto.productDTO.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> getOrders(OrderDTO.Req req);
    Long countOrders(OrderDTO.Req req);
}
