package com.example.demo.admin.services.product.impl;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.productDTO.ProductDTO;
import com.example.demo.admin.mapper.product.ProductMapper;
import com.example.demo.admin.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductMapper productMapper;

    @Override
    public PagedResult<ProductDTO.Res> getProducts(ProductDTO.Req req) {
        // Lấy danh sách sản phẩm theo điều kiện + limit/offset
        List<ProductDTO.Res> items = productMapper.getProducts(req);

        // Lấy tổng số bản ghi để phân trang
        Long totalCount = productMapper.countProducts(req);

        // Wrap vào PagedResult
        PagedResult<ProductDTO.Res> result = new PagedResult<>();
        result.setItems(items);
        result.setTotalCount(totalCount);

        return result;
    }

}
