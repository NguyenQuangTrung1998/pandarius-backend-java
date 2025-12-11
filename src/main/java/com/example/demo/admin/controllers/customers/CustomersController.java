package com.example.demo.admin.controllers.customers;
import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import com.example.demo.admin.services.customers.impl.CustomersImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/customers")
@RestController
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

    @GetMapping("/report/pdf")
    public void exportCustomersReport(HttpServletResponse response) {
        try {
            JasperPrint jasperPrint = customers.generateCustomerReport();

            // Thiết lập header để browser tải file
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers_report.pdf");

            // Xuất PDF ra output stream
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            // xử lý lỗi: log / trả lỗi
            throw new RuntimeException("failed!");
        }
    }
}
