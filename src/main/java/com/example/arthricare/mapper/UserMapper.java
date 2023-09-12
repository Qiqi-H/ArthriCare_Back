package com.example.arthricare.mapper;

import com.example.arthricare.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT point from users where user_id = #{user_id}")
    int findUserScoreById(int user_id);

    @Select("SELECT * from users where email = #{email}")
    User findUserByEmail(@Param("email") String email);


    @Select("SELECT * from users where user_id = #{user_id}")
    User findUserById(int user_id);

    @Insert("INSERT INTO users (name, age, gender, weight, email, password) VALUES " +
            "(#{user.name}, #{user.age}, #{user.gender}, #{user.weight}, #{user.email}, #{user.password})")
    void createUser(@Param("user") User user);


    @Select("SELECT password from users where email = #{email}")
    String getUserPassword(@Param("email")String email);


    @Update("UPDATE users SET password = #{newPassword} WHERE user_id = #{user_id}")
    void resetPassword(@Param("newPassword")String newPassword,@Param("user_id") int user_id);

    @Update("UPDATE users SET point = point + #{newPoint} WHERE user_id = #{user_id}")
    void addPointsToUser(@Param("newPoint") int newPoint, @Param("user_id") int user_id);

    @Update("UPDATE users SET name = #{name}, gender = #{gender}, weight = #{weight}, age = #{age}, email = #{email} WHERE user_id = #{user_id}")
    void updateUserInformation(User user);

    // test for reset

    @Update("UPDATE users SET password = #{newPassword} WHERE email = #{email}")
    void resetPasswordByEmail(@Param("newPassword") String newPassword, @Param("email") String email);


}
