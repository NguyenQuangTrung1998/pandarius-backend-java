package com.example.demo.common.controllers.files;

import com.example.demo.common.dto.fileDTO.FileInfo;
import com.example.demo.common.mapper.files.FileInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty.");
            }

            String originalFilename = file.getOriginalFilename();

            // Lấy base name (bỏ extension)
            String baseName = originalFilename;
            if (originalFilename != null && originalFilename.contains(".")) {
                baseName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            }

            // Lấy extension
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            // Tạo tên file unique: tên gốc không extension + UUID + extension
            String uniqueName = baseName + "_" + java.util.UUID.randomUUID().toString() + extension;

            // Tạo thư mục nếu chưa tồn tại
            Path uploadPath = Paths.get(uploadDir);
            if (Files.notExists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Lưu file vào thư mục upload
            Path filePath = uploadPath.resolve(uniqueName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // URL để lưu vào DB
            String fileUrl = "/files/" + uniqueName;

            // Lưu vào DB
            FileInfo fileInfo = new FileInfo();
            fileInfo.setName(uniqueName);
            fileInfo.setUrl(fileUrl);
            fileInfoMapper.insertFileInfo(fileInfo);

            return ResponseEntity.ok(fileInfo);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Có lỗi trong quá trình upload file.");
        }
    }


    @GetMapping("/files/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
