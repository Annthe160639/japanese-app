package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.AlphabetDto;
import com.prm.japaneseapp.mapper.AlphabetMapper;
import com.prm.japaneseapp.model.entity.AlphabetEntity;
import com.prm.japaneseapp.repository.AlphabetRepository;
import com.prm.japaneseapp.service.AlphabetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AlphabetServiceImpl extends BaseService<AlphabetEntity, AlphabetDto, AlphabetRepository, AlphabetMapper>
        implements AlphabetService {

    @Override
    public ResponseEntity<Object> getAllAlphabet() {
        List<AlphabetDto> alphabetDtos = this.getObjRepository().findAll().stream()
                .map(this.getObjMapper()::entityToDto).toList();
        return this.getResponseFactory().success(alphabetDtos, Object.class);
    }
}
