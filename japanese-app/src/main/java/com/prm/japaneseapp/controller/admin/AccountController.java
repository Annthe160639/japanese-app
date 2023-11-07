package com.prm.japaneseapp.controller.admin;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
@RequestMapping(path = "${adminUrl}/accounts")
public class AccountController extends BaseController<AccountServiceImpl> {

    @GetMapping
    public ResponseEntity<Object> getListAccount() {
        return this.getObjService().getAllAccount();
    }

}
