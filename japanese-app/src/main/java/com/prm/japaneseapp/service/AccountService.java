package com.prm.japaneseapp.service;

import com.prm.japaneseapp.model.request.AccountRequestDto;
import com.prm.japaneseapp.model.request.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<Object> getAllAccount();

    ResponseEntity<Object> login(AuthRequest authRequest);

    ResponseEntity<Object> register(AccountRequestDto account);

}
