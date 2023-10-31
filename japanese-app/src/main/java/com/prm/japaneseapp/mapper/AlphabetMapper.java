package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.response.AlphabetDto;
import com.prm.japaneseapp.model.entity.AlphabetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlphabetMapper extends BaseMapper<AlphabetEntity, AlphabetDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    AlphabetDto entityToDto(AlphabetEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    AlphabetEntity dtoToEntity(AlphabetDto dto);
}
