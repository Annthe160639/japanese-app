package com.prm.japaneseapp.mapper;

import com.prm.japaneseapp.dto.response.AccountResponseDTO;
import com.prm.japaneseapp.model.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<AccountEntity, AccountResponseDTO> {
    @Mapping(target = "role", source = "role", qualifiedByName = "enumToInt")
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToIntStatus")
    AccountResponseDTO entityToDto(AccountEntity user);

    @Mapping(target = "role", source = "role", qualifiedByName = "intToEnum")
    @Mapping(target = "status", source = "status", qualifiedByName = "intToEnumStatus")
    AccountEntity dtoToEntity(AccountResponseDTO dto);
}
