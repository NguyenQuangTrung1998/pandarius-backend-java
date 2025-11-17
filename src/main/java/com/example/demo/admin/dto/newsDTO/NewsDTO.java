package com.example.demo.admin.dto.newsDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class NewsDTO {
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
