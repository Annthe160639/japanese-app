package com.prm.japaneseapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JapaneseEverydayDto {

    private Integer id;

    private String title;

    private String content;

    private Integer status;
}
