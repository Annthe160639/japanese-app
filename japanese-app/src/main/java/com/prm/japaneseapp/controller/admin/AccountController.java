package com.prm.japaneseapp.controller.admin;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${adminUrl}")
public class AccountController extends BaseController<AccountServiceImpl> {

    @GetMapping("/accounts")
    public ResponseEntity<Object> getListAccount() {
        return this.getObjService().getAllAccount();
    }

}
