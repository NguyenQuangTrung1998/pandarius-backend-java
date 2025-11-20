package com.example.demo.admin.mapper.product;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.productDTO.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO.Res> getProducts(ProductDTO.Req req);
    Long countProducts(ProductDTO.Req req);
    ProductDTO.Res getProduct(@Param("id") Long id);
    void updateProduct(@Param("id") Long id , @Param("body") ProductDTO.Body body);

}
