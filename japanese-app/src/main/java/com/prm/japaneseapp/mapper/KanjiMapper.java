package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.KanjiDto;
import com.prm.japaneseapp.model.entity.KanjiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KanjiMapper extends BaseMapper<KanjiEntity, KanjiDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    @Mapping(target = "lesson.status", source = "lesson.status", qualifiedByName = "enumToIntStatus")
    @Mapping(target = "lesson.book.status", source = "lesson.book.status", qualifiedByName = "enumToIntStatus")
    KanjiDto entityToDto(KanjiEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    @Mapping(target = "lesson.status", source = "lesson.status", qualifiedByName = "intToEnumStatus")
    @Mapping(target = "lesson.book.status", source = "lesson.book.status", qualifiedByName = "intToEnumStatus")
    KanjiEntity dtoToEntity(KanjiDto dto);
}
