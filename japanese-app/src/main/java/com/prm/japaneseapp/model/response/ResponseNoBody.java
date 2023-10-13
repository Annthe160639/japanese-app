package com.prm.japaneseapp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseNoBody {
    @JsonProperty("status")
    private ResponseStatus status;
}
