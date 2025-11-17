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
    private String productName;
    private Float price;
    private List<String> sizes;
    private String productType;
    private String description;
    private Integer quantity;
    private String status;
    private String color;
    private String gender;
    private OffsetDateTime creationTime;
    private String discountPercent;
    private float discountPrice;
    private String thumbnailImage;
    private String thumbnailVideo;
    private String guideImage;

}
