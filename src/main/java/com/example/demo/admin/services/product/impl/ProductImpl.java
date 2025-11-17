package com.example.demo.admin.services.product.impl;

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
   public List<ProductDTO.Res> getProducts(ProductDTO.Req req){
        return productMapper.getProducts(req);
    }

}
