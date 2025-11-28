package com.example.demo.admin.mapper.product;
import com.example.demo.admin.dto.productDTO.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO.Res> getProducts(ProductDTO.Req req);
    Long countProducts(ProductDTO.Req req);
    ProductDTO.Res getProduct(@Param("id") Long id);
    void updateProduct(@Param("id") Long id , @Param("body") ProductDTO.Body body);
    void deleteProduct(@Param("id") Long id);

}
