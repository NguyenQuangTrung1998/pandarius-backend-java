package com.example.demo.admin.services.product;

import com.example.demo.admin.dto.productDTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO.Res> getProducts(ProductDTO.Req req);
}
