package com.example.demo.admin.dto.productDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String code;
    private List<String> images;
    private String product_name;
    private Float price;
    private List<String> size;
    private String product_type;
    private String description;
    private Integer quantity;
    private String status;
    private String color;
    private String gender;
    private OffsetDateTime creation_time;
    private String discount_percent;
    private float discount_price;
    private String thumbnail_image;
    private String thumbnail_video;
    private String guide_image;

}
