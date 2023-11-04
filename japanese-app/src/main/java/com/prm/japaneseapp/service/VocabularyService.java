package com.prm.japaneseapp.service;

import org.springframework.http.ResponseEntity;

public interface VocabularyService {

    ResponseEntity<Object> getAllVocabByBookId(Integer lessonId);

}
