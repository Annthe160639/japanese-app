package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.response.LessonDto;
import com.prm.japaneseapp.mapper.LessonMapper;
import com.prm.japaneseapp.model.entity.LessonEntity;
import com.prm.japaneseapp.repository.LessonRepository;
import com.prm.japaneseapp.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LessonServiceImpl extends BaseService<LessonEntity, LessonDto, LessonRepository, LessonMapper>
        implements LessonService {
    private final LessonMapper lessonMapper;


    @Override
    public ResponseEntity<Object> getAllLessonByBookId(Integer bookId) {
        List<LessonDto> lessonDtos = this.getObjRepository().findAllByBook_Id(bookId).stream()
                .map(lessonMapper::entityToDto).toList();
        return this.getResponseFactory().success(lessonDtos, Object.class);
    }
}
