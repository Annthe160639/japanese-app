package com.prm.japaneseapp.controller.user;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.KanjiServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${userUrl}/kanji")
public class KanjiController extends BaseController<KanjiServiceImpl> {
    @GetMapping
    public ResponseEntity<Object> getKanjiByLessonId(@Valid @RequestParam Integer lessonId) {
        return this.getObjService().getAllKanjiByLessonId(lessonId);
    }

}
