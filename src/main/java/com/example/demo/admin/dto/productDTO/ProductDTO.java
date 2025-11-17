package com.example.demo.admin.dto.productDTO;

import com.example.common.paging.PagedRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

public class ProductDTO {
    @Getter
    @Setter
   public class Req extends PagedRequest {
      private String code;
      private String productName;
    }
    @Getter
    @Setter
  public class Res {
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

}
