package com.example.demo.admin.dto.customerDTO;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private OffsetDateTime created_at;
}
