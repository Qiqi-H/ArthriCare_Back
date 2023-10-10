package com.example.arthricare.controller;

import com.example.arthricare.bean.ComityPost;
import com.example.arthricare.bean.valueObject.ComityUserProfileData;
import com.example.arthricare.service.ComityPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ComityPost")
public class ComityPostController {

    private final ComityPostService comityPostService;

    public ComityPostController(ComityPostService comityPostService) {
        this.comityPostService = comityPostService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<Integer> createPost(@RequestBody ComityPost comityPost){
        return ResponseEntity.ok(comityPostService.createPost(comityPost));
    }


    @GetMapping("/getPosts")
    public List<ComityPost> getPostsByCategory(@RequestParam String category,
                                               @RequestParam int start,
                                               @RequestParam int count) {
        List<ComityPost> posts = comityPostService.getPostsByCategory(category, start, count);
        return posts;
    }

    @GetMapping("/getUserPosts")
    public List<ComityPost> getUserPosts(@RequestParam int userId) {
        List<ComityPost> posts = comityPostService.getUserPosts(userId);
        return posts;
    }

    @GetMapping("/getPostById")
    public ResponseEntity<ComityPost> getPostById(@RequestParam int id) {
        ComityPost post = comityPostService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getPostImages")
    public List<String> getPostImages(@RequestParam int postId)
    {
        return comityPostService.getPostImage(postId);
    }

    @GetMapping("/getUserProfileInfor")
    public ComityUserProfileData getUserProfileInfor(@RequestParam int userId)
    {
        return comityPostService.getUserProfileInfor(userId);
    }

    @GetMapping("/getAllPost")
    public List<ComityPost> getAllPost(){
        return comityPostService.getAllPost();
    }

    @GetMapping("/addLikeNum")
    public  ResponseEntity<String> addLikeNum(@RequestParam int postId){

        return ResponseEntity.ok(comityPostService.addLikeNum(postId));
    }

    // don's code
    @DeleteMapping("/deletePost")
    public ResponseEntity<String> deletePost(@RequestParam int postId) {
        // Implement the logic to delete the post and its associated image (if any)
        boolean deleted = comityPostService.deletePost(postId);

        if (deleted) {
            return ResponseEntity.ok("Post deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


