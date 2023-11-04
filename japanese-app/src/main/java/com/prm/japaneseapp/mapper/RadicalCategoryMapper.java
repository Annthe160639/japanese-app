package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.RadicalCategoryDto;
import com.prm.japaneseapp.model.entity.RadicalCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RadicalCategoryMapper extends BaseMapper<RadicalCategoryEntity, RadicalCategoryDto> {
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    RadicalCategoryDto entityToDto(RadicalCategoryEntity entity);

    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    RadicalCategoryEntity dtoToEntity(RadicalCategoryDto dto);
}
