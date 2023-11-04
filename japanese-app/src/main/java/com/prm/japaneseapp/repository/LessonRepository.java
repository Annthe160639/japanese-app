package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.LessonEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends BaseRepository<LessonEntity, Long> {
    List<LessonEntity> findAllByBook_Id(Integer bookId);
}
