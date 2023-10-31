package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.LessonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends BaseRepository<LessonEntity, Long> {
    List<LessonEntity> findAllByBook_Id(Integer bookId);
}
