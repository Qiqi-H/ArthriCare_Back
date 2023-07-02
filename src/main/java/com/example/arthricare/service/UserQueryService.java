package com.example.arthricare.service;

import com.example.arthricare.bean.User;
import com.example.arthricare.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {

    private final UserMapper userMapper;

    public UserQueryService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserByEmail(String email)
    {
        User u =  userMapper.findUserByEmail(email);
        return u;
    }

    public User getUserById(Long id)
    {
        User u = userMapper.findUserById(id);
        return u;
    }


}
