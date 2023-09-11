package com.example.arthricare.mapper;


import com.example.arthricare.bean.ComityPost;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ComityPostMapper {

    @Insert("INSERT INTO community_posts (user_id, title, content, created_timestamp, forum_section,have_image) " +
            "VALUES (#{userId}, #{title}, #{content}, UNIX_TIMESTAMP(#{createdTime}), #{forumSection},#{haveImage})")
    @Options(useGeneratedKeys = true, keyProperty = "postId", keyColumn = "post_id")
    void savePost(ComityPost post);


    @Select("SELECT * FROM community_posts WHERE post_id > #{start} AND forum_section = #{category} LIMIT #{count}")
    List<ComityPost> getPostsByCategory(@Param("category") String category, @Param("start") int start, @Param("count") int count);


    @Select("SELECT * FROM community_posts WHERE user_id = #{user_id}")
    List<ComityPost> getUserPosts(@Param("user_id") int user_id);

    @Select("SELECT * FROM community_posts WHERE post_id = #{post_id}")
    ComityPost getPostById(@Param("post_id") int post_id);


    @Select("SELECT image_path FROM community_posts_images WHERE post_id = #{post_id}")
    List<String> getPostImage(@Param("post_id") int post_id);

    @Select("SELECT COUNT(*) FROM community_posts WHERE user_id = #{user_id}")
    int getUserPostCount(@Param("user_id") int user_Id);

    @Select("SELECT SUM(like_num) FROM community_posts WHERE user_id = #{user_id}")
    int getUserPostLikeCount(@Param("user_id") int user_Id);
}