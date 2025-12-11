package com.example.demo.common.controllers.files;

import com.example.demo.common.dto.fileDTO.FileInfo;
import com.example.demo.common.mapper.files.FileInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//lưu file vào thư mục, url, tên file lưu vào DB
@RestController
@RequestMapping("/files")
public class FileUploadController {

    @Value("${app.file.upload-dir}")
    private String uploadDir; // Đường dẫn lưu file cấu hình ở application.properties

    @Autowired
    private FileInfoMapper fileInfoMapper; // MyBatis mapper để lưu DB

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Tên file gốc
            String originalFilename = file.getOriginalFilename();
            // Tạo đường dẫn file mới (có thể thêm UUID để tránh trùng tên)
            String fileName = System.currentTimeMillis() + "_" + originalFilename;

            // Tạo folder nếu chưa tồn tại
            Path uploadPath = Paths.get(uploadDir);
            if (Files.notExists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Lưu file vào thư mục upload
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Chuẩn bị URL để lưu vào DB (ở đây đặt path relative)
            String fileUrl = "/files/" + fileName;

            // Lưu vào DB
            FileInfo fileInfo = new FileInfo();
            fileInfo.setName(fileName);
            fileInfo.setUrl(fileUrl);
            fileInfoMapper.insertFileInfo(fileInfo);

            return ResponseEntity.ok(fileInfo);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Có lỗi trong quá trình upload file.");
        }
    }
}
