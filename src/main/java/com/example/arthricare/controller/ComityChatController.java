package com.example.arthricare.controller;

import com.example.arthricare.bean.ComityChatChannel;
import com.example.arthricare.bean.valueObject.ChatMessage;
import com.example.arthricare.service.ComityChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ComityChat")
public class ComityChatController {

    private final ComityChatService comityChatService;

    public ComityChatController(ComityChatService comityChatService) {
        this.comityChatService = comityChatService;
    }


    @PostMapping("/createChatChannel")
    public ResponseEntity<ComityChatChannel> createPost(@RequestBody ComityChatChannel comityChatChannel){
        if(!comityChatService.checkChannelExit(comityChatChannel)){
            return ResponseEntity.ok(comityChatService.createChatChannel(comityChatChannel));
        }
        return ResponseEntity.ok(comityChatService.getChatChannelInfor(comityChatChannel));
    }

    @GetMapping("/getChatHistory")
    public ResponseEntity<List<ChatMessage>> getChatHistories(@RequestParam int channelId)
    {
        return ResponseEntity.ok(comityChatService.getChatHistories(channelId));
    }

    @GetMapping("/getChatChannel")
    public ResponseEntity<List<ComityChatChannel>> getChatChannel(@RequestParam String userFromId)
    {
        return ResponseEntity.ok(comityChatService.getChatChannel(userFromId));
    }

}
