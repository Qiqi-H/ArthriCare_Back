package com.example.arthricare.controller;

import com.example.arthricare.bean.ComityPostReply;
import com.example.arthricare.service.ComityPostReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ComityPostReply")
public class ComityPostReplyController {

    private final ComityPostReplyService comityPostReplyService;

    public ComityPostReplyController(ComityPostReplyService comityPostReplyService) {
        this.comityPostReplyService = comityPostReplyService;
    }

    @PostMapping("/addReply")
    public ResponseEntity<String> addReply(@RequestBody ComityPostReply comityPostReply) {
        try {
            comityPostReplyService.createPostReply(comityPostReply);

            return ResponseEntity.ok("Reply added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add reply.");
        }
    }

    @GetMapping("/getReplies")
    public List<ComityPostReply> getReplies(@RequestParam int postId, @RequestParam int start, @RequestParam int count) {
        return comityPostReplyService.getRepliesByPostId(postId, start, count);
    }
}
