package com.prm.japaneseapp.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AccountUpdateRequestDto {

    @NotNull
    private Long id;

    private String lastName;

    private String firstName;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String avatar;
}
