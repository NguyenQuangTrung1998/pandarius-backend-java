package com.example.demo.common.mapper.files;

import com.example.demo.common.dto.fileDTO.FileInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileInfoMapper {
    void insertFileInfo(FileInfo fileInfo);
}
