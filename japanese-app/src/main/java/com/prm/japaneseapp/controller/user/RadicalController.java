package com.prm.japaneseapp.controller.user;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.RadicalServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${userUrl}/radical")
public class RadicalController extends BaseController<RadicalServiceImpl> {
    @GetMapping("/list_radical_category")
    public ResponseEntity<Object> getListAccount() {
        return this.getObjService().getAllRadicalCategory();
    }

    @GetMapping("/list_radical")
    public ResponseEntity<Object> getListAccount(@Valid @RequestParam Integer categoryId) {
        return this.getObjService().getListRadicalByCategoryId(categoryId);
    }
}
