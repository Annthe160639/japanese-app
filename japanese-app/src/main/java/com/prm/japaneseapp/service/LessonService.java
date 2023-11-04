package com.prm.japaneseapp.service;

import org.springframework.http.ResponseEntity;

public interface LessonService {

    ResponseEntity<Object> getAllLessonByBookId(Integer bookId);

}
