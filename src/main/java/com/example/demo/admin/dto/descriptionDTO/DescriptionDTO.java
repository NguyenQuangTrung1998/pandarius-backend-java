package com.example.demo.admin.dto.descriptionDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class DescriptionDTO {
    private Long id;
    private String code;
    private String description;
    private String preserve;
    private OffsetDateTime creationTime;
    private String shortDescription;
}
