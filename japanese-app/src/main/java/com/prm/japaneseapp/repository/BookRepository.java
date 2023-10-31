package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<BookEntity, Long> {

}
