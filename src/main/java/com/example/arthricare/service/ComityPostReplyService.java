package com.example.arthricare.service;

import com.example.arthricare.bean.ComityPostReply;
import com.example.arthricare.mapper.ComityPostMapper;
import com.example.arthricare.mapper.ComityPostReplyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComityPostReplyService {

    private final ComityPostReplyMapper comityPostReplyMapper;
    private final UserQueryService userQueryService;

    public ComityPostReplyService(ComityPostReplyMapper comityPostReplyMapper, UserQueryService userQueryService) {
        this.comityPostReplyMapper = comityPostReplyMapper;
        this.userQueryService = userQueryService;
    }

    public void createPostReply(ComityPostReply comityPostReply)
    {
        comityPostReplyMapper.createPostReply(comityPostReply);
        comityPostReplyMapper.addReplyNumber(comityPostReply.getPostId());
    }

    public List<ComityPostReply> getRepliesByPostId(int postId, int start, int count)
    {
        return comityPostReplyMapper.getRepliesByPostId(postId,start,count);
    }

    public List<ComityPostReply> getAllReplies(int postId)
    {
        List<ComityPostReply> tList = comityPostReplyMapper.getAllReplies(postId);
        for(ComityPostReply c:tList)
        {
            c.setUserName(userQueryService.getUserNameById(c.getUserId()));
        }
        return comityPostReplyMapper.getAllReplies(postId);
    }
}
