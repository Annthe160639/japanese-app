package com.prm.japaneseapp.mapper;


import com.prm.japaneseapp.constant.RoleEnum;
import com.prm.japaneseapp.constant.StatusEnum;
import org.mapstruct.Named;

public interface BaseMapper<E, D> {
    @Named("intToEnum")
    static RoleEnum intToEnum(Integer value) {
        return RoleEnum.fromValue(value);
    }

    @Named("enumToInt")
    static Integer enumToInt(RoleEnum roleEnum) {
        return roleEnum.getValue();
    }

    @Named("intToEnumStatus")
    static StatusEnum intToEnumStatus(Integer value) {
        return StatusEnum.fromValue(value);
    }

    @Named("enumToIntStatus")
    static Integer enumToIntStatus(StatusEnum statusEnum) {
        return statusEnum.getValue();
    }

    D entityToDto(E entity);

    E dtoToEntity(D dto);
}
