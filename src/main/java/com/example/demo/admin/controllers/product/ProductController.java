package com.example.demo.admin.controllers.product;

import com.example.demo.admin.dto.productDTO.ProductDTO;
import com.example.demo.admin.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO.Res> getProducts(@ModelAttribute ProductDTO.Req req){
      return productService.getProducts(req);
    }

}
