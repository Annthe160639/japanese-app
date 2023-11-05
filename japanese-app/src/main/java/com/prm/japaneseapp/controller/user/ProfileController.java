package com.prm.japaneseapp.controller.user;


import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.dto.request.AccountUpdateRequestDto;
import com.prm.japaneseapp.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${apiUrl}/profile")
public class ProfileController extends BaseController<AccountServiceImpl> {

    @PutMapping
    public ResponseEntity<Object> updateProfile(@Valid @RequestBody AccountUpdateRequestDto user) {
        return this.getObjService().update(user);
    }
}
