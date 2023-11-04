package com.prm.japaneseapp.service;

import org.springframework.http.ResponseEntity;

public interface KanjiService {

    ResponseEntity<Object> getAllKanjiByLessonId(Integer lessonId);

}
