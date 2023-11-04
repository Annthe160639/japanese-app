package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.KanjiEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KanjiRepository extends BaseRepository<KanjiEntity, Long> {
    List<KanjiEntity> findAllByLesson_Id(Integer lessonId);
}
