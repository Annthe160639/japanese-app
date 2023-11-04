package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.AlphabetEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphabetRepository extends BaseRepository<AlphabetEntity, Long> {

}
