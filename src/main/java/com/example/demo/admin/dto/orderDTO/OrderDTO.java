package com.example.demo.admin.dto.orderDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OrderDTO {
private Long id;
private OffsetDateTime creation_time;
private String address;
private String note;
private String name;
private String phone_number;
private String email;
private String shipping_fee;
private String sum_total;
private Integer status;
}
