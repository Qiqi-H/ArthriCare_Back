package com.example.arthricare.service;

import com.example.arthricare.mapper.ComityPostMapper;
import com.example.arthricare.mapper.ComityPostReplyMapper;
import com.example.arthricare.mapper.uploadImageMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class uploadImageService {

    @Value("${image-save-path}")
    private String uploadDir;
    private final uploadImageMapper uploadImageMapper;

    public uploadImageService(com.example.arthricare.mapper.uploadImageMapper uploadImageMapper) {
        this.uploadImageMapper = uploadImageMapper;
    }

    public void uploadPostImage(int postId, MultipartFile image) throws IOException {
        uploadImageMapper.savePostImage(postId,saveImage(image));;
    }

    public void uploadReplyImage(int replyId,MultipartFile image) throws IOException {
        saveImage(image);
    }

    private String saveImage(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new IllegalArgumentException("Image file is empty");
        }

        // 生成一个唯一的文件名，结合UUID和当前日期时间
        String uniqueFileName = generateUniqueFileName();

        // 创建保存文件的路径
        Path uploadPath = Path.of(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 将文件保存到指定路径
        Path filePath = uploadPath.resolve(uniqueFileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        String relativeFilePath = "uploadImages\\"+filePath.toString().replace(uploadDir, "");

        // 返回图片的路径
        return relativeFilePath;
    }

    private String generateUniqueFileName() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String uuid = UUID.randomUUID().toString();
        return uuid + "_" + timestamp + ".png"; // 添加 .png 扩展名
    }
}
