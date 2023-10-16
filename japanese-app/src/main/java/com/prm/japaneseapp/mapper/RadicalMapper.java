package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.response.RadicalDto;
import com.prm.japaneseapp.model.entity.RadicalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RadicalMapper extends BaseMapper<RadicalEntity, RadicalDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    RadicalDto entityToDto(RadicalEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    RadicalEntity dtoToEntity(RadicalDto dto);
}
