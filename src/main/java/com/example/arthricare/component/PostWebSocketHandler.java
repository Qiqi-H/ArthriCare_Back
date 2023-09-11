package com.example.arthricare.component;
/*
import com.example.arthricare.bean.ComityPost;
import com.example.arthricare.service.ComityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PostWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ComityPostService postService;


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 接收前端发送的帖子信息
        String postInfo = message.getPayload();
        ObjectMapper objectMapper = new ObjectMapper();
        ComityPost comityPost = objectMapper.readValue(postInfo, ComityPost.class);

        // 在这里将帖子信息保存到数据库，创建新的帖子记录
        postService.savePost(comityPost);

        // 广播帖子保存成功的消息给其他在线用户
        // 假设存在在线用户列表，即在线的WebSocketSession集合 onlineSessions
        session.sendMessage(new TextMessage("New post saved: " + comityPost.getTitle()));
    }
}*/
