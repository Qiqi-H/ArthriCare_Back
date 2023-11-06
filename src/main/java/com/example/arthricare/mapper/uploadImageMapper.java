package com.example.arthricare.mapper;

import com.example.arthricare.bean.ComityPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface uploadImageMapper {

    @Insert("INSERT INTO community_posts_images (post_id, image_path) " +
            "VALUES (#{post_id}, #{image_path})")
    void savePostImage(@Param("post_id") int post_id, @Param("image_path") String image_path);

    @Update("UPDATE users SET avatar_path = #{avatar_path} WHERE user_id = #{user_id}")
    void saveAvatarImage(@Param("user_id") int user_id, @Param("avatar_path") String avatar_path);
}
