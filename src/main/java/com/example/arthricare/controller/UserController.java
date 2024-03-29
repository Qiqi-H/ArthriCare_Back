package com.example.arthricare.controller;

import com.example.arthricare.bean.valueObject.LoginUserData;
import com.example.arthricare.service.UserQueryService;
import com.example.arthricare.service.UserService;
import com.example.arthricare.bean.User;
import com.example.arthricare.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private final UserService userService;
    private final UserQueryService userQueryService;

    public UserController(UserService userService, UserQueryService userQueryService)
    {
        this.userService = userService;
        this.userQueryService = userQueryService;
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        if(userService.UserLogin(user))
        {
            User u = userQueryService.getUserByEmail(user.getEmail());
            LoginUserData l = new LoginUserData(u.getUserId(),u.getName());
            return ResponseEntity.ok(u);
        }
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
        User user = userQueryService.getUserById(userId);
        if (user != null)
        {
            return ResponseEntity.ok(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody User user)
    {
        if(userService.userSignUp(user))
        {
            System.out.println("create");
            return ResponseEntity.ok("register Successfully");
        }
        else
        {
            System.out.println("fail");
            return ResponseEntity.badRequest().body("Sign up failed because this email has already register");
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> userUpdatePassword(@RequestBody User user)
    {
        userService.resetPassword(user.getPassword(),user.getUserId());
        return ResponseEntity.ok("update successfully");
    }


    @PutMapping("/updateUserInformation")
    public ResponseEntity<User> updateUserInformation(@RequestBody User user)
    {
        userService.UpdateUserInformation(user);
        return ResponseEntity.ok(userQueryService.getUserById(user.getUserId()));
    }

    //test for resetpage
    @PutMapping("/updatePasswordbyemail")
    public ResponseEntity<String> userUpdatePasswordbyemail(@RequestBody User user) {
        userService.resetPasswordtest(user.getPassword(), user.getEmail());
        System.out.println("Update successfully");
        return ResponseEntity.ok().build();
    }


    @GetMapping("getUserAvatar/{userId}")
    public ResponseEntity<String> getUserAvatar(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(userService.getUserAvatar(userId));
    }
}
