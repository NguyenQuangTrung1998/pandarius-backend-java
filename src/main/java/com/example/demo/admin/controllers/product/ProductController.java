package com.example.demo.admin.controllers.product;

import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.productDTO.ProductDTO;
import com.example.demo.admin.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public PagedResult<ProductDTO.Res> getProducts(@ModelAttribute ProductDTO.Req req){
      return productService.getProducts(req);
    }
    @GetMapping("/{id}")
    public ProductDTO.Res getProduct(@PathVariable("id") Long id){
        if (id == null){
            return null;
        }
        return productService.getProduct(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDTO.Body body){
        System.out.println("this is body to update: " + body.getProductName() +"\t"+ body.getId());
        productService.updateProduct(body);
    }



}
