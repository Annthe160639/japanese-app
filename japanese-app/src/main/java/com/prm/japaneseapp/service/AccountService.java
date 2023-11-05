package com.prm.japaneseapp.service;

import com.prm.japaneseapp.dto.request.AccountRequestDto;
import com.prm.japaneseapp.dto.request.AccountUpdateRequestDto;
import com.prm.japaneseapp.dto.request.AuthRequestDto;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<Object> getAllAccount();

    ResponseEntity<Object> login(AuthRequestDto authRequest);

    ResponseEntity<Object> register(AccountRequestDto account);

    ResponseEntity<Object> update(AccountUpdateRequestDto account);
}
