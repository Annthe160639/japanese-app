package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.KanjiDto;
import com.prm.japaneseapp.mapper.KanjiMapper;
import com.prm.japaneseapp.model.entity.KanjiEntity;
import com.prm.japaneseapp.repository.KanjiRepository;
import com.prm.japaneseapp.service.KanjiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KanjiServiceImpl extends BaseService<KanjiEntity, KanjiDto, KanjiRepository, KanjiMapper>
        implements KanjiService {

    @Override
    public ResponseEntity<Object> getAllKanjiByLessonId(Integer lessonId) {
        List<KanjiDto> lessonDtos = this.getObjRepository().findAllByLesson_Id(lessonId).stream()
                .map(this.getObjMapper()::entityToDto).toList();
        return this.getResponseFactory().success(lessonDtos, Object.class);
    }
}
