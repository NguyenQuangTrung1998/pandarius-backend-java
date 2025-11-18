package com.example.demo.admin.dto.orderDTO;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

public class OrderDTO {
    @Getter
    @Setter
    public static class Req{
        private OffsetDateTime creationTime;
        private String name;
        private String phoneNumber;
        private String email;
    }
    @Getter
    @Setter
    public static class Res{
        private Long id;
        private OffsetDateTime creationTime;
        private String address;
        private String note;
        private String name;
        private String phoneNumber;
        private String email;
        private String shippingFee;
        private String sumTotal;
        private Integer status;
    }
}
