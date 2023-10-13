package com.prm.japaneseapp.controller;


import com.prm.japaneseapp.model.request.AccountRequestDto;
import com.prm.japaneseapp.model.request.AuthRequest;
import com.prm.japaneseapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${apiUrl}")
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/public/login")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
        return accountService.login(authRequest);
    }

    @PostMapping("/public/register")
    public void register(@RequestBody AccountRequestDto user) {
        accountService.register(user);
    }
}
