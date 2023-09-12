package com.example.arthricare.service;

import com.example.arthricare.bean.ComityChatChannel;
import com.example.arthricare.bean.valueObject.ChatMessage;
import com.example.arthricare.mapper.ComityChatMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComityChatService {

    private final ComityChatMapper comityChatMapper;

    public ComityChatService(ComityChatMapper comityChatMapper) {
        this.comityChatMapper = comityChatMapper;
    }

    public ComityChatChannel createChatChannel(ComityChatChannel comityChatChannel){

        comityChatMapper.createChatChannel(comityChatChannel);
        return comityChatChannel;
    }

    public boolean checkChannelExit(ComityChatChannel comityChatChannel){
       return comityChatMapper.alreadyHaveChannel(comityChatChannel);
    }

    public ComityChatChannel getChatChannelInfor(ComityChatChannel comityChatChannel){
        return comityChatMapper.getChatChannelInfor(comityChatChannel);
    }

    public void recordChat(ChatMessage chatMessage){
        comityChatMapper.recordChat(chatMessage);
        comityChatMapper.updateChatChannel(chatMessage);
    }

    public List<ChatMessage> getChatHistories(int channelId)
    {
        return comityChatMapper.getChatHistories(channelId);
    }

    public List<ComityChatChannel> getChatChannel(String userFromId)
    {
        return comityChatMapper.getChatChannel(userFromId);
    }
}
