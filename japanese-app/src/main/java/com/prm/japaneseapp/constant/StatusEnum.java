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
public enum StatusEnum {
    UNKNOWN(null),

    ENABLE(1),

    DISABLE(0),

    DELETED(-1);

    private final Integer value;

    private static final Map<Integer, StatusEnum> STATUS_MAP = new HashMap<>();

    static {
        for (StatusEnum status : StatusEnum.values()) {
            STATUS_MAP.put(status.value, status);
        }
    }

    @JsonCreator
    public static StatusEnum fromValue(Integer value) {
        if (value == null) {
            return StatusEnum.UNKNOWN;
        }
        StatusEnum status = STATUS_MAP.get(value);
        if (status == null) {
            return StatusEnum.UNKNOWN;
        }
        return status;
    }

    @Converter(autoApply = true)
    public static class RoleConverter implements AttributeConverter<StatusEnum, Integer> {

        @Override
        public Integer convertToDatabaseColumn(StatusEnum role) {
            if (role == null) {
                return null;
            }
            return role.getValue();
        }

        @Override
        public StatusEnum convertToEntityAttribute(Integer value) {
            if (value == null) {
                return null;
            }

            return Stream.of(StatusEnum.values())
                    .filter(s -> s.getValue().equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
