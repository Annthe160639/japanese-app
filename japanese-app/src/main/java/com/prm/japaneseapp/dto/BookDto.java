package com.prm.japaneseapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Integer id;

    private String name;

    private String cover;

    private Integer status;
}
