package com.example.arthricare.mapper;

import com.example.arthricare.bean.ComityPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface uploadImageMapper {

    @Insert("INSERT INTO community_posts_images (post_id, image_path) " +
            "VALUES (#{post_id}, #{image_path})")
    void savePostImage(@Param("post_id") int post_id, @Param("image_path") String image_path);
}
