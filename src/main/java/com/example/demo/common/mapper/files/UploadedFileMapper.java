package com.example.demo.common.mapper.files;

import com.example.demo.common.dto.fileDTO.UploadedFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UploadedFileMapper {
    int insertFile(UploadedFile file);
    UploadedFile selectFileById(@Param("id") Long id);

}
