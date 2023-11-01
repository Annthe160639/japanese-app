package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.response.VocabularyDto;
import com.prm.japaneseapp.mapper.VocabularyMapper;
import com.prm.japaneseapp.model.entity.VocabularyEntity;
import com.prm.japaneseapp.repository.VocabularyRepository;
import com.prm.japaneseapp.service.VocabularyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VocabulalryServiceImpl extends BaseService<VocabularyEntity, VocabularyDto, VocabularyRepository, VocabularyMapper>
        implements VocabularyService {

    @Override
    public ResponseEntity<Object> getAllVocabByBookId(Integer lessonId) {
        List<VocabularyDto> lessonDtos = this.getObjRepository().findAllByLesson_Id(lessonId).stream()
                .map(this.getObjMapper()::entityToDto).toList();
        return this.getResponseFactory().success(lessonDtos, Object.class);
    }
}
