package com.prm.japaneseapp.service;

import com.prm.japaneseapp.model.request.AccountRequestDto;
import com.prm.japaneseapp.model.request.AuthRequest;
import com.prm.japaneseapp.model.response.GeneralResponse;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    GeneralResponse<Object> getAllAccount();

    ResponseEntity<Object> login(AuthRequest authRequest);

    void register(AccountRequestDto account);
}
