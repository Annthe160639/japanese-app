package com.prm.japaneseapp.controller.user;

import com.prm.japaneseapp.controller.BaseController;
import com.prm.japaneseapp.service.impl.VocabulalryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${userUrl}/vocabulary")
public class VocabularyController extends BaseController<VocabulalryServiceImpl> {

    @GetMapping
    public ResponseEntity<Object> getKanjiByLessonId(@Valid @RequestParam Integer lessonId) {
        return this.getObjService().getAllVocabByBookId(lessonId);
    }

}
