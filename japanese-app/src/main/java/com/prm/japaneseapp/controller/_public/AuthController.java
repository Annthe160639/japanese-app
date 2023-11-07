package com.prm.japaneseapp.controller._public;


import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.dto.request.AccountRequestDto;
import com.prm.japaneseapp.dto.request.AuthRequestDto;
import com.prm.japaneseapp.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping(path = "${apiUrl}")
public class AuthController extends BaseController<AccountServiceImpl> {

    @PostMapping("/public/login")
    public ResponseEntity<Object> login(@Valid @RequestBody AuthRequestDto authRequest) throws ParseException {
        return this.getObjService().login(authRequest);
    }

    @PostMapping("/public/register")
    public ResponseEntity<Object> register(@Valid @RequestBody AccountRequestDto user) {
        return this.getObjService().register(user);
    }
}
