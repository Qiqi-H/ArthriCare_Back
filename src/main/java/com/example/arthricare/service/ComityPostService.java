package com.example.arthricare.service;

import com.example.arthricare.bean.ComityPost;
import com.example.arthricare.bean.valueObject.ComityUserProfileData;
import com.example.arthricare.mapper.ComityPostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComityPostService {

    private final ComityPostMapper comityPostMapper;
    private final UserQueryService userQueryService;

    public ComityPostService(ComityPostMapper comityPostMapper, UserQueryService userQueryService)
    {
        this.comityPostMapper = comityPostMapper;
        this.userQueryService = userQueryService;
    }

    public int createPost(ComityPost post)
    {
        comityPostMapper.savePost(post);
        return post.getPostId();
    }

    public List<ComityPost> getPostsByCategory(String category, int start, int count)
    {
        List<ComityPost> posts = comityPostMapper.getPostsByCategory(category,start,count);
        for(ComityPost post:posts)
        {
            post.setUserName(userQueryService.getUserNameById(post.getUserId()));
        }
        return posts;
    }

    public List<ComityPost> getUserPosts(int userId)
    {
        return comityPostMapper.getUserPosts(userId);
    }

    public ComityPost getPostById(int id){
        return comityPostMapper.getPostById(id);
    }

    public List<String> getPostImage(int id)
    {
        return  comityPostMapper.getPostImage(id);
    }

    public ComityUserProfileData getUserProfileInfor(int userId){
        ComityUserProfileData data = new ComityUserProfileData();
        data.setNumPosts(comityPostMapper.getUserPostCount(userId));
        data.setNumLikes(comityPostMapper.getUserPostLikeCount(userId));
        return data;
    }
}
