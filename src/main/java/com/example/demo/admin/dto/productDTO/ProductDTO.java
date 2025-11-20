package com.example.demo.admin.dto.productDTO;

import com.example.common.paging.PagedRequest;
import com.example.common.paging.PagedResult;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

public class ProductDTO {
    @Getter
    @Setter
   public static class Req extends PagedRequest {
      private String code;
      private String productName;
    }

    @Getter
    @Setter
    public static class Body {
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
        private String discountPercent;
        private float discountPrice;
        private String thumbnailImage;
        private String thumbnailVideo;
        private String guideImage;
    }
    @Getter
    @Setter
  public static class Res extends PagedResult {
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
