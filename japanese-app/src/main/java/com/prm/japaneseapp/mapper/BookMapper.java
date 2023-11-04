package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.BookDto;
import com.prm.japaneseapp.model.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper extends BaseMapper<BookEntity, BookDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    BookDto entityToDto(BookEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    BookEntity dtoToEntity(BookDto dto);
}
