package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.response.VocabularyDto;
import com.prm.japaneseapp.model.entity.VocabularyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VocabularyMapper extends BaseMapper<VocabularyEntity, VocabularyDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    @Mapping(target = "lesson.status", source = "lesson.status", qualifiedByName = "enumToIntStatus")
    @Mapping(target = "lesson.book.status", source = "lesson.book.status", qualifiedByName = "enumToIntStatus")
    VocabularyDto entityToDto(VocabularyEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    @Mapping(target = "lesson.status", source = "lesson.status", qualifiedByName = "intToEnumStatus")
    @Mapping(target = "lesson.book.status", source = "lesson.book.status", qualifiedByName = "intToEnumStatus")
    VocabularyEntity dtoToEntity(VocabularyDto dto);
}
