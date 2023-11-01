package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.response.RadicalCategoryDto;
import com.prm.japaneseapp.dto.response.RadicalDto;
import com.prm.japaneseapp.mapper.RadicalCategoryMapper;
import com.prm.japaneseapp.mapper.RadicalMapper;
import com.prm.japaneseapp.model.entity.RadicalEntity;
import com.prm.japaneseapp.repository.RadicalCategoryRespository;
import com.prm.japaneseapp.repository.RadicalRepository;
import com.prm.japaneseapp.service.RadicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RadicalServiceImpl extends BaseService<RadicalEntity, RadicalDto, RadicalRepository, RadicalMapper>
        implements RadicalService {

    private final RadicalCategoryRespository categoryRespository;

    private final RadicalCategoryMapper categoryMapper;

    public ResponseEntity<Object> getAllRadicalCategory() {
        List<RadicalCategoryDto> categoryDtos = categoryRespository.findAll().stream()
                .map(categoryMapper::entityToDto).toList();
        return this.getResponseFactory().success(categoryDtos, Object.class);
    }

    public ResponseEntity<Object> getListRadicalByCategoryId(Integer categoryId) {
        List<RadicalDto> radicalDtos = this.getObjRepository().findAllByRadicalCategory_Id(categoryId)
                .stream().map(this.getObjMapper()::entityToDto).toList();
        return this.getResponseFactory().success(radicalDtos, Object.class);
    }
}
