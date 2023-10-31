package com.prm.japaneseapp.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto {

    private Integer id;

    private String name;

    private BookDto book;

    private String content;

    private Integer status;
}
