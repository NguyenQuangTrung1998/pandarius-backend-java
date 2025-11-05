package com.example.demo.mapper.files;

import com.example.demo.dto.fileDTO.UploadedFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UploadedFileMapper {
    int insertFile(UploadedFile file);
    UploadedFile selectFileById(@Param("id") Long id);

}
