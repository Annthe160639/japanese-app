package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.response.JapaneseEverydayDto;
import com.prm.japaneseapp.model.entity.JapaneseEverydayEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JapaneseEverydayMapper extends BaseMapper<JapaneseEverydayEntity,
        JapaneseEverydayDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    JapaneseEverydayDto entityToDto(JapaneseEverydayEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    JapaneseEverydayEntity dtoToEntity(JapaneseEverydayDto dto);
}
