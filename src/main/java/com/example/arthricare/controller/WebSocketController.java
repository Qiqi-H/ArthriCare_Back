package com.example.arthricare.controller;

import com.example.arthricare.bean.valueObject.ChatMessage;
import com.example.arthricare.service.ComityChatService;
import com.example.arthricare.service.OnlineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;

@Controller
public class WebSocketController {

    @Autowired
    private OnlineUserService onlineUserService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ComityChatService comityChatService;

    @MessageMapping("/register")
    public String registerUser(String username, SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionId();
        // 将用户添加到在线用户服务中
        onlineUserService.userConnected(username, sessionId);
        //System.out.println(username+" register");
        return username;
    }

    @MessageMapping("/leave")
    public String userLeave(String username) {
        onlineUserService.userDisconnected(username);
        //System.out.println(username+" leave");
        return username;
    }

    @MessageMapping("/message")
    public void sendMessageToUser(@Payload ChatMessage chatMessage) {
        String username = chatMessage.getTo();
        if(onlineUserService.checkUserOnlineOrNot(username))
        {
            simpMessagingTemplate.convertAndSend( "/chat/contact/" +username , chatMessage);
        }
        comityChatService.recordChat(chatMessage);
    }
}
