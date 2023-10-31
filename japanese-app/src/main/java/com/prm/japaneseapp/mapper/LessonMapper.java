package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.response.LessonDto;
import com.prm.japaneseapp.model.entity.LessonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper extends BaseMapper<LessonEntity, LessonDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    @Mapping(target = "book.status", source = "book.status", qualifiedByName = "enumToIntStatus")
    LessonDto entityToDto(LessonEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    @Mapping(target = "book.status", source = "book.status", qualifiedByName = "intToEnumStatus")
    LessonEntity dtoToEntity(LessonDto dto);
}
