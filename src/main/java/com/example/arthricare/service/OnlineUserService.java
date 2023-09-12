package com.example.arthricare.service;

import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OnlineUserService {


    private final Map<String, String> onlineUsers = new ConcurrentHashMap<>(); // username -> sessionId

    public void userDisconnected(String username) {

        onlineUsers.remove(username);
    }

    public void userConnected(String username, String sessionId) {
        onlineUsers.put(username, sessionId);
    }

    public boolean checkUserOnlineOrNot(String username){

        return onlineUsers.containsKey(username);
    }

}
