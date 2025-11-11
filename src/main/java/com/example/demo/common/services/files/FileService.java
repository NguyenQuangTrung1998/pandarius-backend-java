package com.example.demo.common.services.files;

import com.example.demo.common.dto.fileDTO.UploadedFile;
import com.example.demo.common.mapper.files.UploadedFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class FileService {
    private final UploadedFileMapper mapper;

    @Autowired
    public FileService(UploadedFileMapper mapper) {
        this.mapper = mapper;
    }

    public Long storeFile(MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new RuntimeException("Invalid path sequence in file name: " + fileName);
            }
            UploadedFile fileEntity = new UploadedFile();
            fileEntity.setFileName(fileName);
            fileEntity.setFileType(multipartFile.getContentType());
            fileEntity.setFileData(multipartFile.getBytes());
            mapper.insertFile(fileEntity);
            return fileEntity.getId();
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public UploadedFile getFile(Long fileId) {
        return mapper.selectFileById(fileId);
    }
}
