package com.example.arthricare.controller;

import com.example.arthricare.bean.User;
import com.example.arthricare.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private UserMapper usermapper;

    @PostMapping("/login")
    //@RequestParam("email") String email, @RequestParam("password") String password
    public ResponseEntity<String> login(@RequestBody User user) {
        User u = usermapper.findUser(user.getEmail(),user.getPassword());
        System.out.println(u);
        return ResponseEntity.ok("Login successful");
    }

}
