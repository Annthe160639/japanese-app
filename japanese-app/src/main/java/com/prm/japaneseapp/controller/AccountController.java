package com.prm.japaneseapp.controller;

import com.prm.japaneseapp.model.response.GeneralResponse;
import com.prm.japaneseapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${apiUrl}/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public GeneralResponse<Object> getListAccount() {
        return accountService.getAllAccount();
    }

}
