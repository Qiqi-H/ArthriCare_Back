package com.example.arthricare.mapper;

import com.example.arthricare.bean.ComityChatChannel;
import com.example.arthricare.bean.ComityPost;
import com.example.arthricare.bean.valueObject.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ComityChatMapper {


    @Insert("INSERT INTO community_chats_channels (user_from_id, user_to_id) " +
            "VALUES (#{userFromId}, #{userToId})")
    @Options(useGeneratedKeys = true, keyProperty = "channelId", keyColumn = "channel_id")
    void createChatChannel(ComityChatChannel comityChatChannel);

    @Insert("INSERT INTO community_chats_histories (channel_id, created_timestamp, content, sender) " +
            "VALUES (#{channelId}, UNIX_TIMESTAMP(#{time}), #{content}, #{from})")
    void recordChat(ChatMessage chatMessage);

    @Select("SELECT COUNT(*) FROM community_chats_channels " +
            "WHERE (user_from_id = #{userFromId} AND user_to_id = #{userToId}) " +
            "OR (user_from_id = #{userToId} AND user_to_id = #{userFromId})")
    boolean alreadyHaveChannel(ComityChatChannel comityChatChannel);

    @Select("SELECT *, FROM_UNIXTIME(last_update_time, \"%Y-%m-%d %H:%i:%s\") AS formatted_time " +
            "FROM `community_chats_channels` " +
            "WHERE (user_from_id = #{userFromId} OR user_to_id = #{userFromId})")
    @Results({
            @Result(property = "channelId", column = "channel_id"),
            @Result(property = "userFromId", column = "user_from_id"),
            @Result(property = "userToId", column = "user_to_id"),
            @Result(property = "newContent", column = "new_content"),
            @Result(property = "lastUpdateTime", column = "formatted_time", javaType = java.util.Date.class),
            })
    List<ComityChatChannel> getChatChannel(@Param("userFromId") String userFromId);

    @Select("SELECT *, FROM_UNIXTIME(last_update_time, \"%Y-%m-%d %H:%i:%s\") AS formatted_time " +
            "FROM `community_chats_channels` " +
            "WHERE (user_from_id = #{userFromId} AND user_to_id = #{userToId}) ")
    @Results({
            @Result(property = "channelId", column = "channel_id"),
            @Result(property = "userFromId", column = "user_from_id"),
            @Result(property = "userToId", column = "user_to_id"),
            @Result(property = "newContent", column = "new_content"),
            @Result(property = "lastUpdateTime", column = "formatted_time", javaType = java.util.Date.class),
    })
    ComityChatChannel getChatChannelInfor(ComityChatChannel comityChatChannel);

    @Select("SELECT *, FROM_UNIXTIME(created_timestamp,\"%Y-%m-%d %H:%m:%s\") AS formatted_time " +
            "FROM community_chats_histories " +
            "WHERE (channel_id = #{channel_id}) ")
    @Results({
            @Result(property = "channelId", column = "channel_id"),
            @Result(property = "content", column = "content"),
            @Result(property = "from", column = "sender"),
            @Result(property = "time", column = "formatted_time", javaType = java.util.Date.class),
    })
    List<ChatMessage> getChatHistories(@Param("channel_id") int channel_id);

    @Update({
            "UPDATE community_chats_channels",
            "SET last_update_time = UNIX_TIMESTAMP(#{time}),",
            "new_content = #{content}",
            "WHERE channel_id = #{channelId}"
    })
    void updateChatChannel(ChatMessage chatMessage);

}
