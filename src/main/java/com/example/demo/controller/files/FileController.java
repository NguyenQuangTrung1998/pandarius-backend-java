package com.example.demo.controller.files;

import com.example.demo.dto.fileDTO.UploadResponse;
import com.example.demo.dto.fileDTO.UploadedFile;
import com.example.demo.services.files.uploadFile.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        Long id = fileService.storeFile(file);
        String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(id.toString())
                .toUriString();
        return ResponseEntity.ok(new UploadResponse(file.getOriginalFilename(), downloadUri, file.getContentType(), file.getSize()));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) {
        UploadedFile fileEntity = fileService.getFile(id);
        ByteArrayResource resource = new ByteArrayResource(fileEntity.getFileData());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .body(resource);
    }
}
