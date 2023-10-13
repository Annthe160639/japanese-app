package com.prm.japaneseapp.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    UNKNOWN(null),

    ADMIN(1),

    STUDENT(2),

    TEACHER(3);

    private final Integer value;

    private static final Map<Integer, RoleEnum> ROLE_MAP = new HashMap<>();

    static {
        for (RoleEnum role : RoleEnum.values()) {
            ROLE_MAP.put(role.value, role);
        }
    }

    @JsonCreator
    public static RoleEnum fromValue(Integer value) {
        if (value == null) {
            return RoleEnum.UNKNOWN;
        }
        RoleEnum partnerType = ROLE_MAP.get(value);
        if (partnerType == null) {
            return RoleEnum.UNKNOWN;
        }
        return partnerType;
    }

    @Converter(autoApply = true)
    public static class RoleConverter implements AttributeConverter<RoleEnum, Integer> {

        @Override
        public Integer convertToDatabaseColumn(RoleEnum role) {
            if (role == null) {
                return null;
            }
            return role.getValue();
        }

        @Override
        public RoleEnum convertToEntityAttribute(Integer value) {
            if (value == null) {
                return null;
            }

            return Stream.of(RoleEnum.values())
                    .filter(r -> r.getValue().equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
