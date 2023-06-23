package com.example.arthricare.mapper;

import com.example.arthricare.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * from users where email = #{email} and password = #{password}")
    User findUser(@Param("email") String email, @Param("password") String password);

    @Select("SELECT * from users where email = #{email}")
    User findUserByEmail(@Param("email") String email);


    @Select("SELECT * from users where id = #{id}")
    User findUserById(Long id);

    @Insert("INSERT INTO users (name, age, gender, weight, email, password) VALUES " +
            "(#{user.name}, #{user.age}, #{user.gender}, #{user.weight}, #{user.email}, #{user.password})")
    void createUser(@Param("user") User user);

    @Select("SELECT password from users where email = #{email}")
    String getUserPassword(@Param("email")String email);


    @Update("UPDATE users SET password = #{newPassword} WHERE id = #{id}")
    void resetPassword(@Param("newPassword")String newPassword,@Param("id") Long id);
}
