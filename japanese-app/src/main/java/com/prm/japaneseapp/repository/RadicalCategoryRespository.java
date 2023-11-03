package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.RadicalCategoryEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadicalCategoryRespository extends BaseRepository<RadicalCategoryEntity, Long> {
}
