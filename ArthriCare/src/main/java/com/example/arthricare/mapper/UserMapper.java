package com.example.arthricare.mapper;

import com.example.arthricare.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * from users where email = #{email} and password = #{password}")
    User findUser(@Param("email") String email, @Param("password") String password);
}
