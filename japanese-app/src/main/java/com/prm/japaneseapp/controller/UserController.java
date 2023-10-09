package com.prm.japaneseapp.controller;

import com.prm.japaneseapp.entity.UserEntity;
import com.prm.japaneseapp.model.AuthRequest;
import com.prm.japaneseapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/public/register")
    public void register(@RequestBody UserEntity user){
        userService.register(user);
    }

    @GetMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        return userService.login(authRequest);
    }
}
