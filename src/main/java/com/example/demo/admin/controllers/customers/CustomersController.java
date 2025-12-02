package com.example.demo.admin.controllers.customers;
import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import com.example.demo.admin.services.customers.impl.CustomersImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersImpl customers;
    @GetMapping
    public PagedResult<CustomerDTO.Res> getCustomers(@ModelAttribute CustomerDTO.Req req) {
        return customers.getCustomers(req);
    }
    @PostMapping
    public void addCustomer(@RequestBody CustomerDTO.Body body){
        customers.addCustomer(body);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customers.deleteCustomer(id);
    }
    @GetMapping("/{id}")
    public CustomerDTO.Res findCustomerById(@PathVariable String id){
        return customers.findCustomerById(id);
    }
}
