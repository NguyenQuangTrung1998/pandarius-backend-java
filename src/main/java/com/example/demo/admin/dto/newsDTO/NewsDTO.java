package com.example.demo.admin.dto.newsDTO;

import com.example.common.paging.PagedRequest;
import com.example.common.paging.PagedResult;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

public class NewsDTO {
    @Getter
    @Setter
    public static class Req extends PagedRequest {
        private String title;
        private String type;
        private OffsetDateTime creationTime;
    }
    @Getter
    public static class Res{
        private Long id;
        private String title;
        private String type;
        private String shortDescription;
        private OffsetDateTime creationTime;
        private String content;
        private String metaTitle;
        private String metaKeyWordSeo;
        private String metaDescription;
        private String image;
    }

}
