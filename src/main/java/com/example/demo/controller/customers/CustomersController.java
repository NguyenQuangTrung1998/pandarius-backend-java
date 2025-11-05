package com.example.demo.controller.customers;
import com.example.demo.dto.customerDTO.CustomerDTO;
import com.example.demo.services.customers.impl.CustomersImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersImpl customers;
    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customers.getCustomers();
    }
}
