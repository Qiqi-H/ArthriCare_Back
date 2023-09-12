package com.example.arthricare.controller;


import com.example.arthricare.service.uploadImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploadImage")
public class uploadImageController {

    private final uploadImageService uploadImageService;

    public uploadImageController(com.example.arthricare.service.uploadImageService uploadImageService) {
        this.uploadImageService = uploadImageService;
    }

    @PostMapping("/postImage")
    public ResponseEntity<String> createPostImage(
            @RequestParam("postId") int postId,
            @RequestParam("image") MultipartFile image
    ) {
        try {
            uploadImageService.uploadPostImage(postId, image);
            return ResponseEntity.ok("upload successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload the image due to an I/O error.");
        }
    }

    @PostMapping("/replyImage")
    public ResponseEntity<String> createReplyImage(
            @RequestParam("replyId") int postId,
            @RequestParam("image") MultipartFile image
    ) {
        try {
            uploadImageService.uploadReplyImage(postId, image);
            return ResponseEntity.ok("upload successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload the image due to an I/O error.");
        }
    }
}
