package com.example.demo.admin.dto.customerDTO;
import com.example.common.paging.PagedRequest;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

public class CustomerDTO {
    @Getter
    @Setter
    public static class Body{
        private String name;
        private String email;
        private String phoneNumber;
        private String address;
    }
    @Getter
    @Setter
    public static class Req extends PagedRequest {
        private String name;
        private String email;
        private String phoneNumber;
        private OffsetDateTime created_at;
    }
    @Getter
    public static class Res extends Body{
        private String id;
        private OffsetDateTime created_at;
    }
}
