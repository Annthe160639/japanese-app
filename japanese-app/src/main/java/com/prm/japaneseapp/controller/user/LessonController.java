package com.prm.japaneseapp.controller.user;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.LessonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${userUrl}/lesson")
public class LessonController extends BaseController<LessonServiceImpl> {
    @GetMapping
    public ResponseEntity<Object> getLessonByBookId(@Valid @RequestParam Integer bookId) {
        return this.getObjService().getAllLessonByBookId(bookId);
    }

}
