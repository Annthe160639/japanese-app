package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.JapaneseEverydayDto;
import com.prm.japaneseapp.mapper.JapaneseEverydayMapper;
import com.prm.japaneseapp.model.entity.JapaneseEverydayEntity;
import com.prm.japaneseapp.repository.JapaneseEverydayRepository;
import com.prm.japaneseapp.service.JapaneseEverydayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JapaneseEverydayServiceImpl extends BaseService<JapaneseEverydayEntity, JapaneseEverydayDto,
        JapaneseEverydayRepository, JapaneseEverydayMapper> implements JapaneseEverydayService {

    @Override
    public ResponseEntity<Object> getAllJapaneseEveryday() {
        List<JapaneseEverydayDto> japaneseEverydayDtos = this.getObjRepository().findAll().stream()
                .map(this.getObjMapper()::entityToDto).toList();
        return this.getResponseFactory().success(japaneseEverydayDtos, Object.class);
    }
}
