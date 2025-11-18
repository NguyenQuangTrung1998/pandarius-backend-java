package com.example.demo.admin.services.orders;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.orderDTO.OrderDTO;

public interface OrderService {
    PagedResult<OrderDTO.Res> getOrders(OrderDTO.Req req);
}
