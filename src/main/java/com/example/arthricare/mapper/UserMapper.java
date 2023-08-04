package com.example.arthricare.mapper;

import com.example.arthricare.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * from users where email = #{email} and password = #{password}")
    User findUser(@Param("email") String email, @Param("password") String password);

    @Select("SELECT point from users where id = #{id}")
    int findUserScoreById(Long id);

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

    @Update("UPDATE users SET point = point + #{newPoint} WHERE id = #{id}")
    void addPointsToUser(@Param("newPoint") int newPoint, @Param("id") Long id);

    @Update("UPDATE users SET name = #{name}, gender = #{gender}, weight = #{weight}, age = #{age}, email = #{email} WHERE id = #{id}")
    void updateUserInformation(User user);

    // test for reset

    @Update("UPDATE users SET password = #{newPassword} WHERE email = #{email}")
    void resetPasswordByEmail(@Param("newPassword") String newPassword, @Param("email") String email);


}
