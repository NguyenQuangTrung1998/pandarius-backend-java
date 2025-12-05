package com.example.demo.admin.services.customers.impl;
import com.example.common.paging.PagedResult;
import com.example.demo.admin.dto.customerDTO.CustomerDTO;
import com.example.demo.admin.mapper.customers.CustomerMapper;
import com.example.demo.admin.services.customers.CustomersService;
import com.example.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomersImpl implements CustomersService {
    private final CustomerMapper customerMapper;
    @Override
    public PagedResult<CustomerDTO.Res> getCustomers(CustomerDTO.Req req){
        // Lấy danh sách sản phẩm theo điều kiện + limit/offset
        List<CustomerDTO.Res> items = customerMapper.getCustomers(req);
        // Lấy tổng số bản ghi để phân trang
        Long totalCount = customerMapper.countCustomers(req);
        // Wrap vào PagedResult
        PagedResult<CustomerDTO.Res> result = new PagedResult<>();
        result.setItems(items);
        result.setTotalCount(totalCount);
        return result;
    }

    @Override
    public void addCustomer(CustomerDTO.Body body) {
      customerMapper.addCustomer(body);
    }

    @Override
    public void deleteCustomer(String id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    public CustomerDTO.Res findCustomerById(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Thông tin không hợp lệ, vui lòng kiểm tra lại!");
        }else {
            CustomerDTO.Res customer = customerMapper.findCustomerById(id);
            if(customer==null){
                throw new ResourceNotFoundException("Không tìm thấy khách hàng với id = " + id);
            }
            return customer;
        }

    }

    //report
    public JasperPrint generateCustomerReport() throws JRException, IOException {
        // 1. Lấy dữ liệu từ DB qua MyBatis
        List<CustomerDTO.Res> customers = customerMapper.findAll();
        // 2. Data source cho Jasper
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customers);
        // 3. Tham số (nếu có)
        Map<String, Object> params = new HashMap<>();
        CustomerDTO.Req dto = new CustomerDTO.Req();
        params.put("name", dto.getName()); // ví dụ
        // 4. Load file .jrxml hoặc .jasper
        InputStream reportStream = this.getClass().getResourceAsStream("/reports/customer_report.jrxml");
        if (reportStream == null) {
            throw new IllegalStateException("Không tìm thấy file customer_report.jrxml");
        }
        // (Optional) kiểm tra file tồn tại / không rỗng
        BufferedReader br = new BufferedReader(new InputStreamReader(reportStream, StandardCharsets.UTF_8));
        if (br.readLine() == null) {
            throw new IllegalStateException("File customer_report.jrxml rỗng");
        }
        br.close();  // hoặc tự đóng

        // Sau đó: mở lại stream để compile
        InputStream compileStream = this.getClass().getResourceAsStream("/reports/customer_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(compileStream);

        // 5. Fill báo cáo
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        return jasperPrint;
    }
}

