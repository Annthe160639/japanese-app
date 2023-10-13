package com.prm.japaneseapp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GeneralResponse<T> {
    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private T data;
}
