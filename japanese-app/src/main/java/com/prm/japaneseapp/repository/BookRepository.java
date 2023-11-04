package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.BookEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<BookEntity, Long> {

}
