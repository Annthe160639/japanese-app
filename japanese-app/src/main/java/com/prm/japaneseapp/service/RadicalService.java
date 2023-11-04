package com.prm.japaneseapp.service;

import org.springframework.http.ResponseEntity;

public interface RadicalService {

    ResponseEntity<Object> getAllRadicalCategory();

    ResponseEntity<Object> getListRadicalByCategoryId(Integer categoryId);
}
