package com.example.arthricare.service;

import com.example.arthricare.bean.User;
import com.example.arthricare.mapper.RewardMapper;
import com.example.arthricare.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final RewardMapper rewardMapper;

    @Autowired
    public UserService(UserMapper userMapper,RewardMapper rewardMapper) {
        this.userMapper = userMapper;
        this.rewardMapper = rewardMapper;
    }

    public boolean UserLogin(User user)
    {
        if(checkUserExitOrNot(user.getEmail()))
        {
            String passwordFromDatabase = userMapper.getUserPassword(user.getEmail());
            return Objects.equals(user.getPassword(), passwordFromDatabase);
        }
        else return false;
    }

    /*    private int id;
    private String name;
    private int age;
    private String gender;
    private BigDecimal weight;
    private String email;
    private String password;*/

    public boolean userSignUp(User user)
    {
        if(!checkUserExitOrNot(user.getEmail()))
        {
            createUser(user);
            return true;
        }
        return false;
    }

    //true exit, false not
    private boolean checkUserExitOrNot(String email)
    {
        return userMapper.findUserByEmail(email) != null;
    }

    private void createUser(User user)
    {
        User u = new User();
        u.setName(user.getName());
        u.setAge(user.getAge());
        u.setGender(user.getGender());
        u.setWeight(user.getWeight());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        userMapper.createUser(u);

        long id = userMapper.findUserByEmail(u.getEmail()).getUserId();
        rewardMapper.createReward(id);
    }

    public void resetPassword(String newPassword,int id)
    {
        userMapper.resetPassword(newPassword,id);
    }


    // test for reset page
    public void resetPasswordtest(String newPassword, String email) {
        User user = userMapper.findUserByEmail(email);
        if (user != null) {
            userMapper.resetPasswordByEmail(newPassword, email);
        } else {
                // maybe do something
        }
    }

    public String UpdateUserInformation(User user)
    {
        userMapper.updateUserInformation(user);
        return "update successfully";
    }
}

