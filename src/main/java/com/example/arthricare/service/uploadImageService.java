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

    @Value("${post-image-save-path}")
    private String uploadPostDir;
    @Value("${puzzle-image-save-path}")
    private String uploadPuzzleDir;
    private String uploadReplyDir;
    @Value("${avatar-image-save-path}")
    private String uploadAvatarDir;
    private final uploadImageMapper uploadImageMapper;

    public uploadImageService(com.example.arthricare.mapper.uploadImageMapper uploadImageMapper) {
        this.uploadImageMapper = uploadImageMapper;
    }

    public void uploadPostImage(int postId, MultipartFile image) throws IOException {
        uploadImageMapper.savePostImage(postId,saveImage(image,uploadPostDir));
    }

    public void uploadReplyImage(int replyId,MultipartFile image) throws IOException {
        saveImage(image,uploadReplyDir);
    }

    private String saveImage(MultipartFile image, String customUploadDir) throws IOException {
        if (image.isEmpty()) {
            throw new IllegalArgumentException("Image file is empty");
        }

        // 生成一个唯一的文件名，结合UUID和当前日期时间
        String uniqueFileName = generateUniqueFileName();

        // 创建保存文件的路径
        Path uploadPath = Path.of(customUploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 将文件保存到指定路径
        Path filePath = uploadPath.resolve(uniqueFileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // 动态生成 relativeFilePath，使用 customUploadDir 中最后一个文件夹的名字
        String lastFolder = uploadPath.getFileName().toString();
        String relativeFilePath = lastFolder + "\\" + filePath.toString().replace(customUploadDir, "");

        // 返回图片的路径
        return relativeFilePath;
    }

    private String generateUniqueFileName() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String uuid = UUID.randomUUID().toString();
        return uuid + "_" + timestamp + ".png"; // 添加 .png 扩展名
    }

    public void uploadAvatarImage(int userId, MultipartFile image) throws IOException {
        uploadImageMapper.saveAvatarImage(userId,saveImage(image,uploadAvatarDir));
    }

    public void uploadPuzzleImage(int puzzleId, MultipartFile image) throws IOException {
        savePuzzleImage(puzzleId, image);
    }

    private void savePuzzleImage(int puzzleId, MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new IllegalArgumentException("Image file is empty");
        }

        // 为拼图创建特定的子目录
        String puzzleSubDir = "puzzleImage/puzzle_" + puzzleId;

        Path puzzleUploadPath = Path.of(uploadPuzzleDir, puzzleSubDir);
        if (!Files.exists(puzzleUploadPath)) {
            Files.createDirectories(puzzleUploadPath);
        }

        // 使用原始文件名保存文件
        String originalFileName = image.getOriginalFilename();
        if (originalFileName == null) {
            throw new IllegalArgumentException("Original file name is null");
        }

        Path filePath = puzzleUploadPath.resolve(originalFileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }

}
