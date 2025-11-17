package com.example.demo.admin.services.product;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.productDTO.ProductDTO;

public interface ProductService {
    PagedResult<ProductDTO.Res> getProducts(ProductDTO.Req req);
}
