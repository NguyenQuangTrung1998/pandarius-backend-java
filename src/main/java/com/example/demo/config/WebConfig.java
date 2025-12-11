package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${app.file.upload-dir}")
    private String uploadDir;
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173","http://localhost:3000","http://localhost:3001")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    /**
     * cấu hình cho phép xem file trên trình duyệt,mobile, frontend SPA...
     * @param registry
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        /**
         * addResourceHandler("/files/**"): bất kỳ request nào bắt đầu bằng /files/ sẽ được chuyển đến file hệ thống
         * addResourceLocations("file:/path/to/uploads/"): Spring sẽ tìm file trong thư mục này trên filesystem
         * 🌐 Ví dụ:
         * Request GET /files/1678901234_myfile.png → Spring tìm /path/to/uploads/1678901234_myfile.png rồi trả file đó cho client.
         */
        registry.addResourceHandler("/files/**")
//                .addResourceLocations("file:" + uploadDir + "/"); - Apply for server
        .addResourceLocations("file:///" + uploadDir + "/"); // -> Apply for windows
    }
}
