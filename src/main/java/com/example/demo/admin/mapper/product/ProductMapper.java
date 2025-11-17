package com.example.demo.admin.mapper.product;

import com.example.demo.admin.dto.productDTO.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
List<ProductDTO.Res> getProducts(ProductDTO.Req req);
ProductDTO getProduct(@Param("id") Long id);
}
