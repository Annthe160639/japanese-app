package com.prm.japaneseapp.controller.user;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.AlphabetServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${userUrl}/alphabet")
public class AlphabetController extends BaseController<AlphabetServiceImpl> {
    @GetMapping
    public ResponseEntity<Object> getListAccount() {
        return this.getObjService().getAllAlphabet();
    }

}
