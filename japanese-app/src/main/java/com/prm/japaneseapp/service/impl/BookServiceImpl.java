package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.response.BookDto;
import com.prm.japaneseapp.mapper.BookMapper;
import com.prm.japaneseapp.model.entity.BookEntity;
import com.prm.japaneseapp.repository.BookRepository;
import com.prm.japaneseapp.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl extends BaseService<BookEntity, BookDto, BookRepository, BookMapper>
        implements BookService {

    @Override
    public ResponseEntity<Object> getAllBook() {
        List<BookDto> bookDtos = this.getObjRepository().findAll().stream()
                .map(this.getObjMapper()::entityToDto).toList();
        return this.getResponseFactory().success(bookDtos, Object.class);
    }
}
