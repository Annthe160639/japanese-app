package com.prm.japaneseapp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus implements Serializable {
    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    public ResponseStatus(ResponseStatusCode responseStatus) {
        this.code = String.valueOf(responseStatus.getHttpCode().value());
        this.timestamp = LocalDateTime.now();
        String messageDb = responseStatus.getMessage();
        if (!messageDb.isEmpty()) {
            this.message = messageDb;
        } else {
            this.message = responseStatus.getHttpCode().getReasonPhrase();
        }
    }
}
