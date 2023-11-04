package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.JapaneseEverydayEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JapaneseEverydayRepository extends BaseRepository<JapaneseEverydayEntity, Long> {

}
