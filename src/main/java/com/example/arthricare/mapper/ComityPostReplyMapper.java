package com.example.arthricare.mapper;

import com.example.arthricare.bean.ComityPost;
import com.example.arthricare.bean.ComityPostReply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ComityPostReplyMapper {

    @Insert("INSERT INTO community_posts_replies (post_id,user_id, content, created_timestamp) " +
            "VALUES (#{postId}, #{userId}, #{content}, UNIX_TIMESTAMP(#{createdTime}))")
    void createPostReply(ComityPostReply comityPostReply);


    @Select("SELECT * FROM community_posts_replies WHERE reply_id > #{start} AND post_id = #{post_id} LIMIT #{count}")
    List<ComityPostReply> getRepliesByPostId(@Param("post_id") int post_id, @Param("start") int start, @Param("count") int count);

    @Select("SELECT * FROM community_posts_replies WHERE post_id = #{post_id} ")
    List<ComityPostReply> getAllReplies(@Param("post_id") int post_id);

    @Update("UPDATE community_posts SET comment_num = comment_num + 1 WHERE post_id = #{post_id}")
    void addReplyNumber(@Param("post_id") int post_id);
}
